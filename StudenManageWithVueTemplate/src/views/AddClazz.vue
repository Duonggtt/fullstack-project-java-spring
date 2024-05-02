
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
                      <a href="/major/list" type="button" class="btn btn-info">
                          <i class="fas fa-redo"></i> Refresh
                      </a>
                  </div>
              </div>

              <div class="row">
                  <div class="col-12">
                      <div class="card">
                          <div class="card-body">
                            <form @submit.prevent="addClazz">
                                <!--name-->
                                <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="className" class="form-label">Tên lớp học</label>
                                    <input id="className"  type="text" name="className" class="form-control" placeholder="Tên lớp học" required v-model="clazz.className">
                                </div>
                                </div>

                                
                                <!--Detail-->
                                <div class="row">
                                    <div class="col-md-12 form-group mb-3">
                                    <label for="courseNum" class="form-label">Khóa thứ</label>
                                    <input id="courseNum" type="text"  name="courseNum" class="form-control" placeholder="Khóa thứ" required v-model="clazz.courseNum" >
                                    </div>
                                </div>

                                <!--Phone Number-->
                                <div class="row">
                                    <div class="col-md-12 form-group mb-3">
                                    <label for="advisorName" class="form-label">Cố vấn học tập</label>
                                    <input id="advisorName" type="text"  name="advisorName" class="form-control" placeholder="Cố vấn học tập" required v-model="clazz.advisorName" >
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12 form-group mb-3">
                                    <label for="monitorName" class="form-label">Lớp trưởng</label>
                                    <input id="monitorName" type="text"  name="monitorName" class="form-control" placeholder="Lớp trưởng" required v-model="clazz.monitorName" >
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
import toastr from 'toastr';

const access_token = localStorage.getItem('access_token');
export default {
        name: 'AddClazz',
        components: {
          Sidebar,Navbar,Footer
        },

        data() {
            return {
                clazz : {
                    className: '',
                    courseNum: '',
                    advisorName: '',
                    monitorName: ''
                }
            }
        },

        methods: {
            addClazz(){
                fetch('http://localhost:8080/api/v1/admin/clazzs/create', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer ${access_token}` // Use the token here
                    },
                    body: JSON.stringify(this.clazz)
                })
                .then(res => {
                        // If the token has expired
                        if (res.status === 403) {
                            toastr.error("Phiên đăng nhập hết hạn!");
                            useAuthStore().logout();
                        }
                        return res;
                    })
                .then(response => {
                    if (response.ok) {
                        toastr.success("Class added successfully.");
                        this.$router.replace("/clazz/list");
                    } else {
                        toastr.error("Failed to add class.");
                    }
                })
                    .catch(error => {
                        router.replace("/");
                    });

            }
        },
    }

</script>