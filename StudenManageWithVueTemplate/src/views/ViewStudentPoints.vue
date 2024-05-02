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
                <h1 class="m-0">Danh sách điểm</h1>
              </div><!-- /.col -->
              <div class="col-sm-6">
                <ol class="breadcrumb float-sm-right">
                  <li class="breadcrumb-item"><a href="/student/list">Home</a></li>
                  <li class="breadcrumb-item active">Danh sách điểm</li>
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
                                          <th>Mã môn học</th>
                                          <th>Tên môn học</th>
                                          <th>Điểm chuyên cần</th>
                                          <th>Điểm giữa kì</th>
                                          <th>Điểm cuối kì</th>
                                          <th>Gpa</th>
                                          <th>Tổng kết</th>
                                          <th>Thao tác</th>
                                      </tr>
                                  </thead>
                                  <tbody>
                                      <tr v-for="point in points" :key="point.id">
                                          <td>{{ point.subject.id }}</td>
                                          <td><p class="text-warning">{{ point.subject.name }}</p></td>
                                          <td>{{ point.diligencePoint  }}</td>
                                          <td>{{ point.midTermPoint  }}</td>
                                          <td>{{ point.finalPoint  }}</td>
                                          <td>{{ point.gpa  }}</td>
                                          <td><p :class="{
                                            'text-success': point.gradeScale.grade === 'A',
                                            'text-info': point.gradeScale.grade === 'B',
                                            'text-warning': point.gradeScale.grade === 'C',
                                            'text-danger': ['A', 'B', 'C'].indexOf(point.gradeScale.grade) === -1
                                            }">{{ point.gradeScale.grade }}</p></td>
                                          

                                          <td>
                                              <a :href="`/point/update/${point.id}`" type="button" class="btn btn-success">
                                                  <i class="fas fa-search"></i>
                                              </a>
                                          </td>
                                      </tr>
                                  </tbody>
                              </table>
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
        name: 'ViewStudentPoints',
        components: {
            Sidebar,Navbar,Pagination,Footer
        },
        data() {
            return {
                currentPage: 1,
                totalPages: 1,
                pageSize: 10,
                points: [],
            }
        },

        beforeMount(){
            this.getPointsByStudent();
        },

        methods: {
            getPointsByStudent() {
                const access_token = localStorage.getItem('access_token');
                const studentId = this.$route.params.id;
                const url = `http://localhost:8080/api/v1/admin/points/student/${studentId}`;

                fetch(url, {
                        headers: {
                            'Authorization': `Bearer ${access_token}` // Use the token here
                        }
                    })
                    .then(res => {
                        // If the token has expired
                        if (res.status === 403) {
                            toastr.error("Phiên đăng nhập hết hạn.");
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
                        this.points = data;
                        console.log(this.points);
                    })
                    .catch(error => {
                        router.replace("/");
                        console.log("Error fetching student point list!", error);
                    });
            },
            
        }

    }

</script>
