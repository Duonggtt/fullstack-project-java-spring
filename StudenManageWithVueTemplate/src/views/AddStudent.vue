
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
              <h1 class="m-0">Thêm mới sinh viên</h1>
            </div><!-- /.col -->
            <div class="col-sm-6">
              <ol class="breadcrumb float-sm-right">
                <li class="breadcrumb-item"><a href="/">Home</a></li>
                <li class="breadcrumb-item active">Thêm mới sinh viên</li>
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
                          <form @submit.prevent="addStudent">
                              <!--name-->
                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="fullName" class="form-label">Họ tên sinh viên</label>
                                    <input id="fullName"  type="text" name="fullName" class="form-control" placeholder="Họ tên đầy đủ của sinh viên" required v-model="student.fullName">
                                </div>
                              </div>

                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="birthDate" class="form-label">Ngày sinh</label>
                                    <input id="birthDate"  type="date" name="birthDate" class="form-control" placeholder="Ngày sinh" required v-model="student.birthDate">
                                </div>
                              </div>

                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="address" class="form-label">Địa chỉ</label>
                                    <input id="address"  type="text" name="address" class="form-control" placeholder="Địa chỉ" required v-model="student.address">
                                </div>
                              </div>

                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="admissionDate" class="form-label">Thời gian nhập học</label>
                                    <input id="admissionDate"  type="date" name="admissionDate" class="form-control" placeholder="Ngày nhập học" required v-model="student.admissionDate">
                                </div>
                              </div>

                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="graduationDate" class="form-label">Thời gian tốt nghiệp</label>
                                    <input id="graduationDate"  type="date" name="graduationDate" class="form-control" placeholder="Thời gian tốt nghiệp" required v-model="student.graduationDate">
                                </div>
                              </div>

                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="gender" class="form-label">Giới tính</label>
                                    <select id="gender" name="gender" class="form-control" required v-model="student.gender">
                                        <option value="">Chọn giới tính</option>
                                        <option value="Nam">Nam</option>
                                        <option value="Nữ">Nữ</option>
                                        <option value="Khác">Khác</option>
                                    </select>
                                </div>
                              </div>

                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="email" class="form-label">Email</label>
                                    <input id="email"  type="text" name="email" class="form-control" placeholder="Email" required v-model="student.email">
                                </div>
                              </div>

                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="phone" class="form-label">Số điện thoại</label>
                                    <input id="phone"  type="text" name="phone" class="form-control" placeholder="Số điện thoại" required v-model="student.phone">
                                </div>
                              </div>

                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="ethnicity" class="form-label">Dân tộc</label>
                                    <input id="ethnicity"  type="text" name="ethnicity" class="form-control" placeholder="Dân tộc" required v-model="student.ethnicity">
                                </div>
                              </div>

                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="ethnicity" class="form-label">Dân tộc</label>
                                    <input id="ethnicity"  type="text" name="ethnicity" class="form-control" placeholder="Dân tộc" required v-model="student.ethnicity">
                                </div>
                              </div>

                              <div class="row">
                                    <div class="col-md-12 form-group">
                                        <input class="btn btn-primary w-100" type="submit" value="Submit">
                                    </div>
                                </div>

                              <div></div>
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
      name: 'AddStudent',
      components: {
        Sidebar,Navbar,Footer
      },

      data() {
          return {
              student : {
                  fullName: '',
                  birthDate: '',
                  address: '',
                  admissionDate: '',
                  graduationDate: '',
                  gender: '',
                  email: '',
                  phone: '',
                  ethnicity: ''
              }
          }
      },

      methods: {
          addStudent(){
              fetch('http://localhost:8080/api/v1/admin/students/create', {
                  method: 'POST',
                  headers: {
                      'Content-Type': 'application/json',
                      'Authorization': `Bearer ${access_token}` // Use the token here
                  },
                  body: JSON.stringify(this.student)
              })
              .then(res => {
                        // If the token has expired
                        if (res.status === 403) {
                            toastr.error("Phiên đăng nhập hết hạn.");
                            useAuthStore().logout();
                        }
                        return res;
                    })
              .then(response => {
                  if (response.ok) {
                      toastr.success("Student added successfully.");
                      this.$router.push("/student/list");
                  } else {
                      toastr.error("Failed to add student.");
                  }
              })
                    .catch(error => {
                        router.replace("/");
                    });

          }
      },
  }

</script>