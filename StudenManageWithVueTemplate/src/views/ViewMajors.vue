
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
                <h1 class="m-0">Danh sách các ngành</h1>
              </div><!-- /.col -->
              <div class="col-sm-6">
                <ol class="breadcrumb float-sm-right">
                  <li class="breadcrumb-item"><a href="/">Home</a></li>
                  <li class="breadcrumb-item active">Danh sách các ngành</li>
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
                              <table class="table table-bordered table-hover">
                                  <thead>
                                      <tr>
                                          <th>Mã ngành</th>
                                          <th>Tên ngành học</th>
                                          <th>Chi tiết</th>
                                          <th>Số năm học</th>
                                          <th>Thao tác</th>
                                      </tr>
                                  </thead>
                                  <tbody>
                                      <tr v-for="major in majors" :key="major.id">
                                          <td>{{ major.id }}</td>
                                          <td><p class="text-warning">{{ major.majorName }}</p></td>
                                          <td>{{ major.detail }}</td>
                                          <td>{{ major.yearQuantity }}</td>
                                          <td>
                                              <a :href="`/major/update/${major.id}`" type="button" class="btn btn-success">
                                                  <i class="fas fa-search"></i>
                                              </a>
                                              <a  @click="deleteMajor(major.id)" type="button" class="btn btn-success" style="background-color: tomato;margin-left: 10px;" >
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
import router from '../router';
import toastr from 'toastr';
import { useAuthStore } from '../stores/auth';

const access_token = localStorage.getItem('access_token');
    export default {
        name: 'ViewMajors',
        components: {
            Sidebar,Navbar,Pagination,Footer
        },
        data() {
            return {
                currentPage: 1,
                totalPages: 1,
                pageSize: 10,
                majors: []
            }
        },

        beforeMount(){
            this.getMajors()
        },

        methods: {
            getMajors() {
                console.log(access_token);
                const url = `http://localhost:8080/api/v1/admin/majors/?page=${this.currentPage}&limit=${this.pageSize}`;

                fetch(url , {
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
                    .then(res => res.json())
                    .then(data => {
                        this.majors = data.content;
                        this.totalPages = data.totalPages;
                        console.log(data);
                    })
                    .catch(error => {
                        router.replace("/");
                        console.log("Error fetching major list!", error);
                    });
            },
            changePage(pageNumber) {
                if (pageNumber >= 1 && pageNumber <= this.totalPages) {
                    this.currentPage = pageNumber;
                    this.getMajors();
                }
            },
            
            nextPage() {
                if (this.currentPage < this.totalPages) {
                    this.currentPage++;
                    this.getMajors();
                }
            },
            
            prevPage() {
                if (this.currentPage > 1) {
                    this.currentPage--;
                    this.getMajors();
                }
            },
            deleteMajor(id){
                if (confirm("Are you sure you want to delete this major?")) {
                    fetch(`http://localhost:8080/api/v1/admin/majors/${id}`, {
                    method: 'DELETE'
                    })
                    .then(data => {
                        console.log(data)
                        toastr.success("Major deleted successfully.");
                        this.getMajors()
                    })
                }else {
                    toastr.error("Delete operation cancelled.");
                }
            }
        }

    }

</script>