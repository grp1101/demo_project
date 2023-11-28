<template>
  <div>
    <h1>Test_Page</h1>
    <router-link to="router_test">임시버튼</router-link>
    <router-view></router-view>
    <br />
    <br />
    <br />
    <button
      type="button"
      class="btn"
      v-on:click="loadUserList()"
      style="background-color: #ffffff; border-radius: 20px"
    >
      검색
    </button>
    <h1>Test_Grid</h1>
    <AgGridVue
      style="width: 100%; height: 300px"
      class="ag-theme-apline"
      :columnDefs="columnDefs"
      @grid-ready="onGridReady"
      :rowData="rowData"
      :defaultColDef="defaultColDef"
      @row-selected="onRowSelected"
    >
    </AgGridVue>
  </div>
</template>

<script>
import { ref, onBeforeMount } from "vue";
// import axios from "axios";

// specify the data
let UserList = [
  { user_seq: "Toyota", email: "Celica", password: 35000 },
  { user_seq: "Porsche", email: "Boxster", password: 72000 },
  { user_seq: "Aston Martin", email: "DBX", password: 190000 },
];

export default {
  name: "test-page",
  data() {
    return {};
  },
  components: {},
  setup() {
    //https://velog.io/@skyepodium/vue-ref-%EC%86%8D%EC%84%B1-feat.-%EC%A3%BC%EC%9D%98%ED%95%A0-%EC%A0%90
    //ref : DOM 접근하기 위한 속성
    const columnDefs = ref([
      { field: "user_seq", editable: false },
      { field: "authority", editable: true },
      { field: "email", editable: false },
      { field: "username", editable: false },
      { field: "nickname", editable: false },
      { field: "birth", editable: false },
      { field: "address", editable: false },
      { field: "phone", editable: false },
      { field: "website", editable: false },
      { field: "company", editable: false },
      { field: "advertisment", editable: false },
      { field: "reg_date", editable: false },
    ]);
    const gridApi = ref();
    const gridColumnApi = ref();
    const defaultColDef = ref({
      // editable: true,
      // cellDataType: false,
    });
    const rowData = ref(null);
    const rowSelection = ref(null);

    onBeforeMount(() => {
      rowData.value = UserList;
    });

    const onGridReady = (params) => {
      gridApi.value = params.api;
      gridColumnApi.value = params.columnApi;

      // const updateData = (data) => params.api.setRowData(data);

      // fetch("https://www.ag-grid.com/example-assets/olympic-winners.json")
      //   .then((resp) => resp.json())
      //   .then((data) => updateData(data));
    };

    // const onSelectionChanged = () => {
    //   const selectedRows = gridApi.value.getSelectedRows();
    //   console.log(selectedRows);
    //   document.querySelector("#selectedRows").innerHTML =
    //     selectedRows.length === 1 ? selectedRows[0].athlete : "";
    // };

    // const onCellValueChanged = async () => {
    //   const selectedRows = gridApi.value.getSelectedRows();
    //   console.log(selectedRows);

    //   await axios(
    //     {
    //       method: "post",
    //       url: "/system/UpdateUserAuth",
    //     },
    //     { withCredentials: true }
    //   )
    //     .then((response) => {
    //       console.log("response.data = ", response.data);
    //     })
    //     .finally(() => {
    //       console.log("/system/UpdateUserAuth 실행");
    //     });
    // };

    //https://codesandbox.io/p/sandbox/sharp-meadow-h3k5m4?file=%2Fmain.js%3A53%2C17
    const onRowSelected = (event) => {
      window.alert(
        "row " +
          event.node.data.athlete +
          " selected = " +
          event.node.isSelected()
      );
    };

    return {
      columnDefs,
      gridApi,
      gridColumnApi,
      rowData,
      rowSelection,
      defaultColDef,
      onGridReady,
      onRowSelected,
    };
  },
  beforeMount() {},
  created() {},
  watch: {
    // UserList(beforeValue, afterValue) {
    //   console.log("beforeValue : ", beforeValue);
    //   console.log("afterValue : ", afterValue);
    // },
  },
  methods: {
    loadUserList() {
      this.axios(
        {
          method: "post",
          url: "/system/selectUserList",
        },
        { withCredentials: true }
      )
        .then((response) => {
          console.log("response.data = ", response.data);
          UserList = response.data;
          console.log("UserList = ", UserList);

          this.gridApi.setRowData(UserList);
        })
        .finally(() => {
          console.log("/system/selectUserList 실행");
        });
    },
    UpdateUserAuth() {
      this.axios(
        {
          method: "post",
          url: "/system/UpdateUserAuth",
        },
        { withCredentials: true }
      )
        .then((response) => {
          console.log("response.data = ", response.data);
        })
        .finally(() => {
          console.log("/system/UpdateUserAuth 실행");
        });
    },
  },
};
</script>
