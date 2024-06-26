import { defineStore } from 'pinia';
import router from '../router';
import toastr from 'toastr';

export const useAuthStore = defineStore({
    id: 'auth',
    state: () => ({
        user: localStorage.getItem('user'),
        access_token: localStorage.getItem('access_token'),
        refresh_token: localStorage.getItem('refresh_token'),
        returnUrl: '/student/list', // replace with your success route
    }),
    actions: {
        async login(username, password) {
            const formData = new FormData();
            formData.append('username', username);
            formData.append('password', password);
            const url = 'http://localhost:8080/api/login'; // replace with your login endpoint
        
            let response = await fetch(url, {
                method: 'POST',
                body: formData,
            });
        
            // If the token has expired
            if (response.status === 403) {
                // Store the current URL
                localStorage.setItem('redirectUrl', window.location.href);
                
                // Call your refresh token function here
                await this.refreshToken();
        
                // Retry the request with the new token
                response = await fetch(url, {
                    method: 'POST',
                    body: formData,
                    headers: {
                        'Authorization': `Bearer ${this.access_token}` // Use the new token here
                    }
                });
            }
        
            if(response.status === 200) {
                const { access_token, refresh_token } = await response.json();
                localStorage.setItem('user', username);
                localStorage.setItem('access_token', access_token);
                localStorage.setItem('refresh_token', refresh_token);
                this.user = username;
                this.access_token = access_token;
                this.refresh_token = refresh_token;
                // Get the stored URL
                const redirectUrl = localStorage.getItem('redirectUrl');
                // Remove the stored URL
                localStorage.removeItem('redirectUrl');
                // Redirect to the stored URL if it exists, otherwise to the default returnUrl
                router.push(redirectUrl || this.returnUrl);
                toastr.success('Logged in successfully'); // adjust if your application handles success differently
            } else {
                toastr.error('Invalid username or password'); // adjust if your application handles errors differently
            }
        },
        
        async refreshToken() {
            const response = await fetch('http://localhost:8080/api/token/refresh', { // replace with your refresh token endpoint
                method: 'GET',
                headers: { 'Authorization': `Bearer ${this.refresh_token}` },
            });
        
            if(response.status === 200) {
                const { access_token } = await response.json(); // adjust if your server returns a different data structure
                localStorage.setItem('access_token', access_token);
                this.access_token = access_token;
            } else {
                toastr.error('Failed to refresh token'); // adjust if your application handles errors differently
                this.logout();
            }
        },
        logout() {
            this.user = null;
            this.access_token = '';
            this.refresh_token = '';
            localStorage.removeItem('user');
            localStorage.removeItem('access_token');
            localStorage.removeItem('refresh_token');
            router.push('/'); // replace with your logout route
        }
    }
});