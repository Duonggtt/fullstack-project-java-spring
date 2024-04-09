<template>
    <div class="d-flex justify-content-center mt-3" id="pagination">
      <nav aria-label="Page navigation example">
        <ul class="pagination">
          <li class="page-item" :class="{ 'disabled': currentPage === 1 }">
            <a class="page-link" href="#" @click.prevent="prevPage">Previous</a>
          </li>
          <li class="page-item" v-for="pageNumber in totalPages" :key="pageNumber" :class="{ 'active': pageNumber === currentPage }">
            <a class="page-link" href="#" @click.prevent="changePage(pageNumber)">{{ pageNumber }}</a>
          </li>
          <li class="page-item" :class="{ 'disabled': currentPage === totalPages }">
            <a class="page-link" href="#" @click.prevent="nextPage">Next</a>
          </li>
        </ul>
      </nav>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      currentPage: {
        type: Number,
        required: true
      },
      totalPages: {
        type: Number,
        required: true
      },
      prevPage: {
        type: Function,
        required: true
      },
      nextPage: {
        type: Function,
        required: true
      },
      changePage: {
        type: Function,
        required: true
      }
    }
  }
  </script>
  