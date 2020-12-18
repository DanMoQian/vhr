<template>
    <div>
        <!--主体部分-->
        <el-card>

            <el-row :gutter="25">
                <el-col :span="10">
                    <!--搜索区域-->
                    <!-- 搜索添加 -->
                    <el-input placeholder="请输入搜索内容"  clearable >
                        <el-button slot="append" icon="el-icon-search" ></el-button>
                    </el-input>
                </el-col>
                <el-col :span="4">
                    <!--搜索按钮-->
                    <el-button type="primary" align="right">添加奖惩记录</el-button>
                </el-col>
            </el-row>

            <el-table :data="perEc" border stripe>
                <el-table-column label="序号" prop="id"></el-table-column>
                <el-table-column label="员工编号" prop="eid"></el-table-column>
                <el-table-column label="员工姓名" prop="name"></el-table-column>
                <el-table-column label="奖罚原因" prop="ecreason"></el-table-column>
                <el-table-column label="奖罚分" prop="ecpoint"></el-table-column>
                <el-table-column label="奖罚类别" prop="ectype">
                    <!--作用域插槽-->
                    <template slot-scope="scope">
                        <!--{{scope.row}}每一行封存数据-->
                        <el-switch v-model="scope.row.ectype" active-color="#ff4949"
                                   inactive-color="#13ce66" disabled></el-switch>
                    </template>
                </el-table-column>
                <el-table-column label="备注(总分)" prop="remark"></el-table-column>
                <el-table-column label="奖罚日期" prop="ecdate"></el-table-column>
            </el-table>
        </el-card>
    </div>
</template>

<script>
    export default {
        name: "PerEc",
        data() {
            return {
                perEc: [],
                page: 0,
                pageSize: 10,
                totalCount: 0,
            }
        },
        created() {
            this.initPerEc();
        },
        methods: {
            initPerEc() {
                this.getRequest(`/employeeec/basic/?page=` + this.page + `&pageSize=` + this.pageSize).then(resp => {
                    this.perEc = resp.data;
                    /*this.perEc = resp.data.data;
                    this.totalCount = resp.data.total;*/
                })
            }
        }
    }
</script>

<style scoped>

</style>