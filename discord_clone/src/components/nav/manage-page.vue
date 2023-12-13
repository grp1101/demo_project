<template>
  <div>
    <navContent></navContent>
    <div id="header">
      <h3>
        유저권한 설정
        <button
          type="button"
          id="searchBtn"
          class="btn btn btn-outline-secondary"
          v-on:click="loadUserList()"
          style="background-color: #ffffff; border-radius: 20px"
        >
          검색
        </button>
      </h3>
    </div>
    <font-awesome-icon icon="faMagnifyingGlass" />
    <AgGridVue
      style="width: 100%; height: 300px"
      class="ag-theme-alpine themeClass"
      :columnDefs="columnDefs"
      @grid-ready="onGridReady"
      :defaultColDef="defaultColDef"
      :rowSelection="rowSelection"
      :rowData="rowData"
      @row-selected="onRowSelected"
      :onCellValueChanged="onCellValueChanged"
      :sideBar="sideBar"
    >
    </AgGridVue>

    <!-- <footerContent></footerContent> -->
  </div>
</template>

<script>
import { ref, onBeforeMount } from "vue";
import axios from "axios";

//https://codesandbox.io/p/sandbox/pedantic-dirac-72vcsl?file=%2Fmain.js%3A12%2C51-13%2C36

// specify the data
// let UserList = [];

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
      {
        // headerName: "유저권한 설정",
        children: [
          { field: "user_seq", editable: false, filters: "agTextColumnFilter" },
          { field: "authority", editable: true, filters: "agTextColumnFilter" },
          { field: "email", editable: false, filters: "agTextColumnFilter" },
          { field: "username", editable: false, filters: "agTextColumnFilter" },
          { field: "nickname", editable: false, filters: "agTextColumnFilter" },
          { field: "birth", editable: false, filters: "agTextColumnFilter" },
          { field: "address", editable: false, filters: "agTextColumnFilter" },
          { field: "phone", editable: false, filters: "agTextColumnFilter" },
          { field: "website", editable: false, filters: "agTextColumnFilter" },
          { field: "company", editable: false, filters: "agTextColumnFilter" },
          {
            field: "advertisment",
            editable: false,
            filters: "agTextColumnFilter",
          },
          { field: "reg_date", editable: false, filters: "agTextColumnFilter" },
        ],
      },
    ]);
    const gridApi = ref();
    const gridColumnApi = ref();
    const defaultColDef = ref({
      // editable: true,
      // cellDataType: false,
    });
    const rowData = ref(null);
    const rowSelection = ref(null);
    const sideBar = ref(null);

    onBeforeMount(() => {
      rowData.value = UserList;
      rowSelection.value = "multiple";

      sideBar.value = "columns";
    });

    const onGridReady = (params) => {
      gridApi.value = params.api;
      gridColumnApi.value = params.columnApi;
    };

    const onCellValueChanged = async () => {
      const selectedRows = gridApi.value.getSelectedRows();
      console.log(selectedRows);

      await axios(
        {
          method: "post",
          url: "/system/UpdateUserAuth",
          data: selectedRows[0],
        },
        { withCredentials: true }
      )
        .then((response) => {
          console.log("response.data = ", response.data);
        })
        .finally(() => {
          console.log("/system/UpdateUserAuth 실행");
        });
    };

    //https://codesandbox.io/p/sandbox/sharp-meadow-h3k5m4?file=%2Fmain.js%3A53%2C17
    const onRowSelected = (event) => {
      console.log(event);
    };

    return {
      columnDefs,
      gridApi,
      gridColumnApi,
      defaultColDef,
      rowSelection,
      rowData,
      onGridReady,
      onRowSelected,
      onCellValueChanged,
      themeClass: "ag-theme-quartz",
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

<style>
#header {
  padding: 1%;
}
#searchBtn {
  float: right;
}
</style>
