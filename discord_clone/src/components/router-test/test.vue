<template>
  <div>
    <h1>Test_Page</h1>
    <router-link to="router_test">임시버튼</router-link>
    <router-view></router-view>
    <br />
    <br />
    <br />
    <h1>Test_Grid</h1>
    <AgGridVue
      style="width: 500px; height: 500px"
      class="ag-theme-apline-dark"
      :columnDefs="columnDefs"
      @grid-ready="onGridReady"
      :rowData="rowData"
      :defaultColDef="defaultColDef"
    >
    </AgGridVue>
  </div>
</template>

<script>
import { ref, onBeforeMount } from "vue";

export default {
  name: "test-page",
  data() {
    return {};
  },
  components: {},
  setup(props) {
    //https://velog.io/@skyepodium/vue-ref-%EC%86%8D%EC%84%B1-feat.-%EC%A3%BC%EC%9D%98%ED%95%A0-%EC%A0%90
    //ref : DOM 접근하기 위한 속성
    this.columnDefs = ref([
      { field: "make" },
      { field: "model" },
      { field: "price" },
    ]);

    this.rowData = ref([
      { make: "Toyota", model: "Celica", price: 35000 },
      { make: "Ford", model: "Mondeo", price: 32000 },
      { make: "Porsche", model: "Boxter", price: 72000 },
    ]);

    const gridApi = ref();
    const gridColumnApi = ref();
    const defaultColDef = ref({
      editable: true,
      cellDataType: false,
    });

    const rowData = ref(null);

    onBeforeMount(() => {});

    const onGridReady = (params) => {
      gridApi.value = params.api;
      gridColumnApi.value = params.columnApi;

      const updateData = (data) => params.api.setRowData(data);

      fetch("https://www.ag-grid.com/example-assets/olympic-winners.json")
        .then((resp) => resp.json())
        .then((data) => updateData(data));
    };

    return {
      columnDefs,
      gridApi,
      gridColumnApi,
      defaultColDef,
      rowData,
      onGridReady,
    };
  },
  beforeMount() {},
};
</script>
