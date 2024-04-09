
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
                    <a :href="`/student/update/${student.id}`" type="button" class="btn btn-info">
                        <i class="fas fa-redo"></i> Refresh
                    </a>
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                          <form @submit.prevent="updateStudent">

                              <!--id-->
                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="fullName" class="form-label">Họ tên sinh viên</label>
                                    <input id="fullName"  type="text" name="fullName" class="form-control" placeholder="Họ tên đầy đủ của sinh viên" required v-model="student.fullName">
                                </div>
                              </div>

                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="birthDate" class="form-label">Ngày sinh</label>
                                    <input type="date" name="birthDate" class="form-control" id="birthDate" v-model="student.birthDate">
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
                                    <input type="date" name="admissionDate" class="form-control" id="admissionDate" v-model="student.admissionDate">
                                </div>
                              </div>

                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="graduationDate" class="form-label">Thời gian tốt nghiệp</label>
                                    <input type="date" name="graduationDate" class="form-control" id="graduationDate" v-model="student.graduationDate">
                                </div>
                              </div>

                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="gender" class="form-label">Giới tính</label>
                                    <input id="gender"  type="text" name="gender" class="form-control" placeholder="giới tính" required v-model="student.gender">
                                </div>
                              </div>

                              <div class="row">
                                <label for="clazz" class="form-label">Lớp</label>
                                <div class="col-md-11 form-group mb-3 d-flex justify-content-between">
                                  <div class="input-group col-md-3">
                                    <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search" v-model="searchClazzId">
                                    <div class="input-group-append" style="background-color: antiquewhite;border-radius: 5px; margin-right: 10px;">
                                      <button class="btn btn-sidebar" @click="searchClazz">
                                        <i class="fas fa-search fa-fw"></i>
                                      </button>
                                    </div>
                                    <button class="btn btn-info" @click="addClazzId">
                                      <i class="fas fa-plus"></i>
                                    </button>
                                  </div>
                                  <div class="d-flex justify-content-around gap-4">
                                    <input id="clazzName" type="text" name="clazz" class="form-control col-md-4" v-model="clazz.className" placeholder="Tên lớp">
                                    <input id="clazzCourseNum" type="text" name="clazz" class="form-control col-md-4" v-model="clazz.courseNum" placeholder="Khóa thứ">
                                    <input id="clazzStudentNum" type="text" name="clazz" class="form-control col-md-4" v-model="clazz.advisorName" placeholder="Số học sinh">
                                  </div>
                                </div>
                              </div>
                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="clazzId" class="form-label">Chọn lớp</label>
                                    <input id="clazzId"  type="text" name="clazzId" class="form-control" placeholder="clazzId" required v-model="clazz.className">
                                </div>
                              </div>

                              <div class="row">
                                <label for="clazz" class="form-label">Ngành học</label>
                                <div class="col-md-11 form-group mb-3 d-flex justify-content-between">
                                  <div class="input-group col-md-3"  data-widget="sidebar-search">
                                    <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
                                    <div class="input-group-append" style="background-color: antiquewhite;border-radius: 5px; ">
                                      <button class="btn btn-sidebar" @click="searchMajor">
                                        <i class="fas fa-search fa-fw"></i>
                                      </button>
                                    </div>
                                    <button class="btn btn-info" @click="addMajorId">
                                      <i class="fas fa-plus"></i>
                                    </button>
                                  </div>
                                  <div class="d-flex justify-content-around gap-4">
                                    <input id="major" type="text" name="major" class="form-control col-md-4" placeholder="Tên ngành" v-model="major.majorName">
                                    <input id="major" type="text" name="major" class="form-control col-md-4" placeholder="Chi tiết xem tại list" disabled >
                                    <input id="major" type="text" name="major" class="form-control col-md-4" placeholder="Số năm học" v-model="major.yearQuantity">
                                  </div>
                                </div>
                              </div>
                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="majorId" class="form-label">Chọn ngành</label>
                                    <input id="majorId"  type="text" name="majorId" class="form-control" placeholder="clazzId" required v-model="major.majorName">
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
                                    <label for="status" class="form-label">Trạng thái</label>
                                    <input id="status"  type="text" name="status" class="form-control" placeholder="Trạng thái" required v-model="student.status">
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
      name: 'UpdateStudent',
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
                  ethnicity: '',
                  gpa: '',
                  status: '',
                  clazzId: '',
                  majorId: ''
              },
              clazz: {
                className: '',
                courseNum: '',
                advisorName: '',
                monitorName: ''
              },
              major: {
                majorName: '',
                detail: '',
                yearQuantity: ''
              },
              searchClazzId: '' ,
              searchMajorId: '' 
          }
      },
      mounted() {
          // Fetch major data to edit
          this.getStudentData();
      },

      methods: { 
        getMajorData(getMajorId) {
              getMajorId = this.student.majorId;
              console.log(access_token);
              fetch(`http://localhost:8080/api/v1/admin/majors/${getMajorId}`, {
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
                      // Cập nhật thông tin lớp vào clazzData
                      this.major = {
                        majorName: data.majorName,
                        detail: data.detail,
                        yearQuantity: data.yearQuantity
                      };
                  })
                    .catch(error => {
                        router.replace("/");
                        console.log("Error fetching student!", error);
                        toastr.error('Authorization!');
                    });
          }, 
          getClazzData(getClazzId) {
            getClazzId = this.student.clazzId;
              fetch(`http://localhost:8080/api/v1/admin/clazzs/${getClazzId}`, {
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
                          throw new Error('Failed to fetch class data.');
                      }
                  })
                  .then(data => {
                      // Cập nhật thông tin lớp vào clazzData
                      this.clazz = {
                          className: data.className,
                          courseNum: data.courseNum,
                          advisorName: data.advisorName,
                          monitorName: data.monitorName
                      };
                  })
                  .catch(error => {
                      console.error('Error fetching class data:', error);
                  });
          },
          searchMajor() {
            event.preventDefault();
            fetch(`http://localhost:8080/api/v1/admin/majors/search/${this.searchMajorId}`, {
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
                this.major = {
                  majorName: data.majorName,
                  detail: data.detail,
                  yearQuantity: data.yearQuantity
                };
              })
              .catch(error => {
                console.error('Error fetching major data:', error);
              });
          },
          addMajorId() {
            if (!this.searchMajorId) {
              alert("Vui lòng nhập ID của major trước khi thêm.");
              return;
            }
            this.student.majorId = parseInt(this.searchMajorId);
          },
          searchClazz() {
            event.preventDefault();
            fetch(`http://localhost:8080/api/v1/admin/clazzs/search/${this.searchClazzId}`, {
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
                  throw new Error('Failed to fetch class data.');
                }
              })
              .then(data => {
                this.clazz = {
                  className: data.className,
                  courseNum: data.courseNum,
                  advisorName: data.advisorName,
                  monitorName: data.monitorName
                };
              })
              .catch(error => {
                console.error('Error fetching class data:', error);
              });
          },
           // Hàm thêm thông tin ID của clazz
          addClazzId() {
            if (!this.searchClazzId) {
              alert("Vui lòng nhập ID của clazz trước khi thêm.");
              return;
            }
            this.student.clazzId = parseInt(this.searchClazzId);
          },
          getStudentData() {
              // Fetch major data using the major ID from the URL parameter
              const studentId = this.$route.params.id;
              fetch(`http://localhost:8080/api/v1/admin/students/${studentId}`, {
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
                      throw new Error('Failed to fetch student data.');
                  }
              })
              .then(data => {
                  // Update major object with fetched data
                  this.student = {
                      id: data.id,
                      fullName: data.fullName,
                      birthDate: this.formatDate(data.birthDate),
                      address: data.address,
                      admissionDate: this.formatDate(data.admissionDate),
                      graduationDate: this.formatDate(data.graduationDate),
                      gender: data.gender,
                      email: data.email,
                      phone: data.phone,
                      ethnicity: data.ethnicity,
                      gpa: data.gpa,
                      status: data.status,
                      clazzId: data.clazz ? data.clazz.id : null,
                      majorId: data.major ? data.major.id : null
                  };
                  console.log(this.student)
                  this.getClazzData(this.student.clazzId);
                  this.getMajorData(this.student.majorId);

              })
              .catch(error => {
                  console.error('Error fetching student data:', error);
              });
          },
          updateStudent() {
              fetch(`http://localhost:8080/api/v1/admin/students/update/${this.student.id}`, {
                  method: 'PUT',
                  headers: {
                      'Content-Type': 'application/json',
                      'Authorization': `Bearer ${access_token}`
                  },
                  body: JSON.stringify({
                      fullName: this.student.fullName,
                      birthDate: this.student.birthDate,
                      address: this.student.address,
                      admissionDate: this.student.admissionDate,
                      graduationDate: this.student.graduationDate,
                      gender: this.student.gender,
                      email: this.student.email,
                      phone: this.student.phone,
                      ethnicity: this.student.ethnicity,
                      gpa: this.student.gpa,
                      status: this.student.status,
                      clazzId: parseInt(this.student.clazzId),
                      majorId: parseInt(this.student.majorId)
                  })
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
                      alert("Student updated successfully.");
                      this.getClazzData();
                      this.$router.replace(`/student/update/${this.student.id}`);
                  } else {
                      alert("Failed to update student.");
                      
                  console.log(this.student);
                  }
              })
              .catch(error => {
                  console.error("Error updating student:", error);
              });
          },
          formatDate(dateString) {
              if (!dateString) return null; // Handle null or empty strings
              const date = new Date(dateString);
              const year = date.getFullYear();
              let month = (1 + date.getMonth()).toString();
              month = month.length > 1 ? month : '0' + month;
              let day = date.getDate().toString();
              day = day.length > 1 ? day : '0' + day;
              return year + '-' + month + '-' + day;
          },

      },
  }

</script>