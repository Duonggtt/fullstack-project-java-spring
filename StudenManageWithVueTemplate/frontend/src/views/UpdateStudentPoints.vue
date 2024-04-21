
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
                <h1 class="m-0">Thêm mới ngành học</h1>
              </div><!-- /.col -->
              <div class="col-sm-6">
                <ol class="breadcrumb float-sm-right">
                  <li class="breadcrumb-item"><a href="/">Home</a></li>
                  <li class="breadcrumb-item active">Thêm mới ngành học</li>
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
                      <a :href="`/major/update/${major.id}`" type="button" class="btn btn-info">
                          <i class="fas fa-redo"></i> Refresh
                      </a>
                  </div>
              </div>

              <div class="row">
                  <div class="col-12">
                      <div class="card">
                          <div class="card-body">
                            <form @submit.prevent="updateMajor">

                                <!--id-->
                                <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="majorId" class="form-label">Mã ngành học</label>
                                    <input id="majorId"  type="text" name="id" class="form-control" placeholder="Mã ngành học" required v-model="major.id" disabled>
                                </div>
                                </div>
                                
                                <!--name-->
                                <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="majorName" class="form-label">Tên ngành học</label>
                                    <input id="majorName"  type="text" name="majorName" class="form-control" placeholder="Tên ngành học" required v-model="major.majorName">
                                </div>
                                </div>

                                
                                <!--Detail-->
                                <div class="row">
                                    <div class="col-md-12 form-group mb-3">
                                    <label for="detail" class="form-label">Chi tiết</label>
                                    <input id="detail" type="text"  name="detail" class="form-control" placeholder="Chi tiết ngành học" required v-model="major.detail" >
                                    </div>
                                </div>

                                <!--Phone Number-->
                                <div class="row">
                                    <div class="col-md-12 form-group mb-3">
                                    <label for="yearQuantity" class="form-label">Số năm học</label>
                                    <input id="yearQuantity" type="text"  name="yearQuantity" class="form-control" placeholder="Số năm học" required v-model="major.yearQuantity" >
                                    </div>
                                </div>
                    
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        <input class="btn btn-primary w-100" type="submit" value="Submit">
                                    </div>
                                </div>
                    
                                <div>
                                
                                </div>
                            </form>

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
import Footer from '../components/Footer.vue'; 
import router from '../router';

import { useAuthStore } from '../stores/auth';
const access_token = localStorage.getItem('access_token');
export default {
        name: 'UpdataStudentPoints',
        components: {
          Sidebar,Navbar,Footer
        },

        data() {
            return {
                major : {
                    majorName: '',
                    detail: '',
                    yearQuantity: ''
                }
            }
        },
        mounted() {
            // Fetch major data to edit
            this.getMajorData();
        },

        methods: {
            getMajorData() {
                // Fetch major data using the major ID from the URL parameter
                const majorId = this.$route.params.id;
                fetch(`http://localhost:8080/api/v1/admin/majors/${majorId}`, {
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
                .then(response => {
                    if (response.ok) {
                        return response.json();
                    } else {
                        throw new Error('Failed to fetch major data.');
                    }
                })
                .then(data => {
                    // Update major object with fetched data
                    this.major = {
                        id: data.id,
                        majorName: data.majorName,
                        detail: data.detail,
                        yearQuantity: data.yearQuantity
                    };
                })
                    .catch(error => {
                        router.replace("/");
                        console.log("Error fetching major!", error);
                        toastr.error('Authorization!');
                    });
            },
            updateMajor() {
                fetch(`http://localhost:8080/api/v1/admin/majors/${this.major.id}`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer ${access_token}` 
                    },
                    body: JSON.stringify(this.major)
                })
                .then(res => {
                        // If the token has expired
                        if (res.status === 403) {
                            alert("Token has expired. Please login again.");
                            useAuthStore().logout();
                        }
                        return res;
                    })
                .then(response => {
                    if (response.ok) {
                        alert("Major updated successfully.");
                        this.$router.replace("/major/list");
                    } else {
                        alert("Failed to update major.");
                    }
                })
                .catch(error => {
                    console.error("Error updating major:", error);
                });
            }
        },
    }

</script>