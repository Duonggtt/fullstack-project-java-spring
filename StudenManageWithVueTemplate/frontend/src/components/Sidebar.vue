<template>
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="index3.html" class="brand-link">
          <img src="../assets/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
          <span class="brand-text font-weight-light">Student Manage</span>
        </a>
    
        <!-- Sidebar -->
        <div class="sidebar">
          <!-- Sidebar user panel (optional) -->
          <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
              <img src="../assets/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
            </div>
            <div class="info">
              <a href="#" class="d-block">Alexander Pierce</a>
            </div>
          </div>
    
          <!-- SidebarSearch Form -->
          <div class="form-inline">
            <div class="input-group" data-widget="sidebar-search">
              <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
              <div class="input-group-append">
                <button class="btn btn-sidebar">
                  <i class="fas fa-search fa-fw"></i>
                </button>
              </div>
            </div>
          </div>
    
          <!-- Sidebar Menu -->
          <nav class="mt-2">
              <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                

                <li class="nav-item">
                  <a href="#" class="nav-link">
                    <i class="nav-icon fas fa-columns"></i>
                    <p>
                      Quản lý ngành học
                      <i class="fas fa-angle-left right"></i>
                    </p>
                  </a>
                  <ul class="nav nav-treeview">
                    <li class="nav-item">
                      <a href="/major/list" class="nav-link">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Danh sách ngành học</p>
                      </a>
                    </li>
                    <li class="nav-item">
                      <a href="/major/create" class="nav-link">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Thêm mới ngành học</p>
                      </a>
                    </li>
                  </ul>
                </li>
                
                <li class="nav-item">
                  <a href="#" class="nav-link">
                    <i class="nav-icon fas fa-th"></i>
                    <p>
                        Quản lý lớp học
                      <i class="right fas fa-angle-left"></i>
                    </p>
                  </a>
                  <ul class="nav nav-treeview">
                    <li class="nav-item">
                      <a href="/clazz/list" class="nav-link">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Danh sách lớp</p>
                      </a>
                    </li>
                    <li class="nav-item">
                      <a href="/clazz/create" class="nav-link">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Thêm lớp học</p>
                      </a>
                    </li>
                  </ul>
                </li>
                <li class="nav-item">
                  <a href="#" class="nav-link">
                    <i class="nav-icon fas fa-edit"></i>
                    <p>
                      Quản lý sinh viên
                      <i class="fas fa-angle-left right"></i>
                    </p>
                  </a>
                  <ul class="nav nav-treeview">
                    <li class="nav-item">
                      <a href="/student/list" class="nav-link">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Danh sách sinh viên</p>
                      </a>
                    </li>
                    <li class="nav-item">
                      <a href="/student/create" class="nav-link">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Thêm mới sinh viên</p>
                      </a>
                    </li>
                  </ul>
                </li>
                
                
              </ul>
            </nav> 
          <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
      </aside>

</template>