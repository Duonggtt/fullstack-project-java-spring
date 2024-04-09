<template>
    <main>
    <div class="wrapper">
      
      <!-- Navbar -->
      <Navbar/>
      <!-- /.navbar -->
  
      <!-- Main Sidebar Container -->
      <Sidebar/>
    
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
          <div class="container-fluid">
            <div class="row mb-2">
              <div class="col-sm-6">
                <h1 class="m-0">Danh sách sinh viên</h1>
              </div><!-- /.col -->
              <div class="col-sm-6">
                <ol class="breadcrumb float-sm-right">
                  <li class="breadcrumb-item"><a href="/">Home</a></li>
                  <li class="breadcrumb-item active">Danh sách sinh viên</li>
                </ol>
              </div><!-- /.col -->
            </div><!-- /.row -->
          </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->
    
        <!-- Main content -->
        <section class="content">
          <div class="container-fluid">
              <div class="row py-2">
                  <div class="col-12">
                      <a href="/student/list" type="button" class="btn btn-info">
                          <i class="fas fa-redo"></i> Refresh
                      </a>
                  </div>
              </div>

              <div class="row">
                  <div class="col-12">
                      <div class="card">
                          <div class="card-body">
                              <table class="table table-bordered table-hover">
                                  <thead>
                                      <tr>
                                          <th>ID</th>
                                          <th>Tên sinh viên</th>
                                          <th>Ngày sinh</th>
                                          <th>Địa chỉ</th>
                                          <th>Ngành học</th>
                                          <th>Giới tính</th>
                                          <th>Lớp</th>
                                          <th>Trạng thái</th>
                                          <th>Thao tác</th>
                                      </tr>
                                  </thead>
                                  <tbody>
                                      <tr v-for="student in students" :key="student.id">
                                          <td>{{ student.id }}</td>
                                          <td><p class="text-warning">{{ student.fullName }}</p></td>
                                          <td>{{ formatDate(student.birthDate) }}</td>
                                          <td>{{ student.address }}</td>
                                          <td>
                                            {{ student.major ? student.major.majorName : 'Chưa chọn ngành' }}
                                          </td>
                                          <td>{{ student.gender }}</td>
                                          <td :class="{ 'text-danger': !student.clazz, 'text-success': student.clazz }">
                                            {{ student.clazz ? student.clazz.className : 'Chưa có lớp' }}
                                        </td>
                                        <td>
                                            <p :class="getStatusColor(student.status)">{{ student.status }}</p>
                                        </td>

                                          <td>
                                              <a :href="`/student/update/${student.id}`" type="button" class="btn btn-success">
                                                  <i class="fas fa-search"></i>
                                              </a>
                                              <a  @click="deleteStudent(student.id)" type="button" class="btn btn-success" style="background-color: tomato;" >
                                                  <i class="fas fa-trash"></i>
                                              </a>
                                          </td>
                                      </tr>
                                  </tbody>
                              </table>

                              <!-- pagination -->
                              <Pagination :currentPage="currentPage" :totalPages="totalPages" :prevPage="prevPage" :nextPage="nextPage" :changePage="changePage" />
                              
                          </div>
                      </div>
                  </div>
              </div>
            
          </div><!-- /.container-fluid -->
        </section>
        <!-- /.content -->
      </div>
      <!-- /.content-wrapper -->
      <Footer/>
    
      <!-- Control Sidebar -->
      <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
      </aside>
      <!-- /.control-sidebar -->
    </div>
        
    </main>
</template>


<script>
import Sidebar from '../components/Sidebar.vue'
import Navbar from '../components/Navbar.vue'
import Pagination from '../components/Pagination.vue'; 
import Footer from '../components/Footer.vue'; 
import toastr from 'toastr';
import router from '../router';
import { useAuthStore } from '../stores/auth';


    export default {
        name: 'ViewStudents',
        components: {
            Sidebar,Navbar,Pagination,Footer
        },
        data() {
            return {
                currentPage: 1,
                totalPages: 1,
                pageSize: 10,
                students: []
            }
        },

        beforeMount(){
            this.getStudents()
        },

        methods: {
            getStudents() {
                const access_token = localStorage.getItem('access_token');
                console.log(access_token);
                const url = `http://localhost:8080/api/v1/admin/students/?page=${this.currentPage}&limit=${this.pageSize}`;

                fetch(url, {
                        headers: {
                            'Authorization': `Bearer ${access_token}` // Use the token here
                        }
                    })
                    .then(res => {
                        // If the token has expired
                        if (res.status === 403) {
                            alert("Token has expired. Please login again.");
                            useAuthStore().logout();
                        }
                        return res;
                    })
                    .then(res => {
                        if (!res.ok) {
                            throw new Error(`Server responded with status code ${res.status}`);
                        }
                        return res.json();
                    })
                    .then(data => {
                        this.students = data.content;
                        this.totalPages = data.totalPages;
                        console.log(data);
                    })
                    .catch(error => {
                        router.replace("/");
                        console.log("Error fetching student list!", error);
                        toastr.error('Authorization!');
                    });
            },
            changePage(pageNumber) {
                if (pageNumber >= 1 && pageNumber <= this.totalPages) {
                    this.currentPage = pageNumber;
                    this.getStudents();
                }
            },
            
            nextPage() {
                if (this.currentPage < this.totalPages) {
                    this.currentPage++;
                    this.getStudents();
                }
            },
            
            prevPage() {
                if (this.currentPage > 1) {
                    this.currentPage--;
                    this.getStudents();
                }
            },
            deleteStudent(id){
                if (confirm("Are you sure you want to delete this student?")) {
                    fetch(`http://localhost:8080/api/v1/admin/students/${id}`, {
                    method: 'DELETE'
                    })
                    .then(data => {
                        console.log(data)
                        alert("Student deleted successfully.");
                        this.getStudents()
                    })
                }else {
                    alert("Delete operation cancelled.");
                }
            },
            formatDate(date) {
                const options = { day: '2-digit', month: '2-digit', year: 'numeric' };
                const formattedDate = new Date(date).toLocaleDateString('en-US', options);
                const [month, day, year] = formattedDate.split('/');
                return `${day}/${month}/${year}`;
            },
            getStatusColor(status) {
            switch (status) {
                case 'Đang học':
                    return 'text-success'; // Màu xanh
                case 'Bỏ học':
                    return 'text-danger'; // Màu đỏ
                case 'Bảo lưu':
                    return 'text-warning'; // Màu vàng
                default:
                    return ''; // Mặc định không áp dụng lớp màu
            }
        },
        }

    }

</script>