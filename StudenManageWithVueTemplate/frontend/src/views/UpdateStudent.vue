
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
              <h1 class="m-0">Chi tiết sinh viên</h1>
            </div><!-- /.col -->
            <div class="col-sm-6">
              <ol class="breadcrumb float-sm-right">
                <li class="breadcrumb-item"><a href="/">Home</a></li>
                <li class="breadcrumb-item active">Chi tiết sinh viên</li>
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
                    <a :href="`/student/update/${student.id}`" type="button" class="btn btn-info" style="margin-right: 10px;">
                        <i class="fas fa-redo"></i> Refresh
                    </a>

                    <a :href="`/student/${student.id}/points`" type="button" class="btn btn-warning">
                      <i class="fas fa-search"></i> Xem điểm
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
                                    <label for="studentId" class="form-label">Mã sinh viên</label>
                                    <input id="studentId" disabled type="text" name="studentId" class="form-control" placeholder="Mã sinh viên" required v-model="student.id">
                                </div>
                              </div>

                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="fullName" class="form-label">Họ tên sinh viên</label>
                                    <input id="fullName"  type="text" name="fullName" class="form-control" placeholder="Họ tên đầy đủ của sinh viên" required v-model="student.fullName">
                                </div>
                              </div>

                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="birthDate" class="form-label">Ngày sinh</label>
                                    <input type="date" name="birthDate" class="form-control" id="birthDate" required v-model="student.birthDate">
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
                                    <label for="cmnd" class="form-label">Số căn cước công dân</label>
                                    <input type="text" name="cmnd" class="form-control" id="cmnd" required v-model="student.cmnd">
                                </div>
                              </div>

                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                  <label for="gender" class="form-label">Giới tính</label>
                                  <select id="gender" name="gender" class="form-control" required v-model="student.genderId">
                                    <option value="">-- Chọn giới tính --</option>
                                    <option v-for="gender in genders" :value="gender.id" :key="gender.id">
                                      {{ gender.genderName }}
                                    </option>
                                  </select>
                                </div>
                              </div>

                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                  <label for="clazz" class="form-label">Lớp</label>
                                  <div class="input-group col-md-2" style="margin-bottom: 10px;">
                                    <input class="input-group rounded-pill" type="search" placeholder="Nhập ID:" aria-label="Search" v-model="searchClazzId" style="padding-left:10px;padding-right:50px;;border: 1px solid #ced4da; box-shadow: 0 0 10px rgba(0,0,0,.1);position: relative;width: 100%;">
                                    <div class="input-group-append">
                                      <button class="btn btn-outline-secondary rounded-pill" style="position: absolute;right:15px; border: none;" type="button" @click="searchClazz">
                                        <i class="fas fa-search fa-fw"></i>
                                      </button>
                                    </div>
                                  </div>

                                      <table class="table co-12" >
                                        <p v-if="searchClicked && !clazzSearch.id">Không tồn tại lớp mang ID này</p>

                                        <thead>
                                          <tr>
                                            <th scope="col">Mã lớp</th>
                                            <th scope="col">Tên lớp</th>
                                            <th scope="col">Khóa</th>
                                            <th scope="col">Năm học</th>
                                            <th scope="col">Thao tác</th>
                                          </tr>
                                        </thead>
                                        <tbody>
                                          <tr>
                                            <td>{{ clazzSearch.id }}</td>
                                            <td>{{ clazzSearch.className }}</td>
                                            <td>{{ clazzSearch.courseId }}</td>
                                            <td>{{ clazzSearch.academicYearId }}</td>
                                            <td>
                                              <button class="btn btn-outline-info ml-2" @click="addClazzId" v-if="clazzSearch.id">
                                                <i class="fas fa-plus"></i>
                                              </button>
                                            </td>
                                          </tr>
                                        </tbody>
                                      </table>
                                </div>
                              </div>
                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="clazzId" class="form-label">Lớp đã chọn</label>
                                    <input disabled id="clazzId"  type="text" name="clazzId" class="form-control" placeholder="clazzId" required v-model="clazz.className">
                                </div>
                              </div>

                              <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                  <label for="majorId" class="form-label">Ngành học</label>
                                  <select id="majorId" name="majorId" class="form-control" required v-model="student.majorId">
                                    <option value="">-- Chọn ngành học --</option>
                                    <option v-for="major in majors" :value="major.id" :key="major.id">
                                      {{ major.majorName }}
                                    </option>
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
import toastr from 'toastr';
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
                  gender: '',
                  email: '',
                  phone: '',
                  cmnd: '',
                  ethnicity: '',
                  gpa: '',
                  status: '',
                  genderId: '',
                  clazzId: '',
                  majorId: ''
              },
              clazz: {
                id: '',
                className: '',
                courseId: '',
                academicYearId: '',
              },
              clazzSearch: {
                id: '',
                className: '',
                courseId: '',
                academicYearId: '',
              },
              majors: [],
              genders: [],
              searchClazzId: '' ,
              searchMajorId: '' ,
              searchClicked: false,
          }
      },
      mounted() {
          // Fetch major data to edit
          this.getStudentData();
      },

      methods: { 
        getGenderData() {
          fetch(`http://localhost:8080/api/v1/admin/genders/`, {
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
                          throw new Error('Failed to fetch gender data.');
                      }
                  })
                  .then(data => {
                      this.genders = data;
                      console.log(data)
                  })
                    .catch(error => {
                        console.log("Error fetching genders!", error);
                    });
        },
        getMajorData(getMajorId) {
              getMajorId = this.student.majorId;
              console.log("access_token: ",access_token);
              fetch(`http://localhost:8080/api/v1/admin/majors/list`, {
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
                      this.majors = data;
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
                        id: data.id,
                        className: data.className,
                        courseId: data.courseId,
                        academicYearId: data.academicYearId, 
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
            
            this.searchClicked = true;
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
                this.clazzSearch = {
                  id: data.id,
                        className: data.className,
                        courseId: data.courseId,
                        academicYearId: data.academicYearId, 
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
                      cmnd: data.cmnd,
                      genderId: data.gender ? data.gender.id : null,
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
                  this.getGenderData(this.student.genderId);

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
                      genderId: parseInt(this.student.genderId),
                      email: this.student.email,
                      phone: this.student.phone,
                      cmnd: this.student.cmnd,
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
                      toastr.success("Student updated successfully.");
                      this.getClazzData();
                      this.$router.replace(`/student/update/${this.student.id}`);
                      window.scrollTo(0, 0);
                      toastr("Student updated successfully.");
                  } else {
                    toastr.error("Failed to update student.");
                      
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