<template>
	<el-main class="bg table_wrap">
		<el-form label-position="right" :model="query" class="form p_4" label-width="120">
			<el-row>


										<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="年">
									<el-input v-model="query.year"></el-input>
								</el-form-item>
				</el-col>
									<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="月">
									<el-input v-model="query.month"></el-input>
								</el-form-item>
				</el-col>
																																																										<el-col :xs="24" :sm="10" :lg="8" class="search_btn_wrap_1">
					<el-form-item>
						<el-button type="primary" @click="search()" class="search_btn_find">查询</el-button>
						<el-button @click="reset()" style="margin-right: 74px;" class="search_btn_reset">重置</el-button>
						<router-link v-if="user_group == '管理员' || $check_action('/meteorological_data/table','add') || $check_action('/meteorological_data/view','add')" class="el-button el-button--default el-button--primary search_btn_add" to="./view?">添加
						</router-link>
            			<el-button v-if="user_group == '管理员' || $check_action('/meteorological_data/table','del') || $check_action('/meteorological_data/view','del')" class="search_btn_del" type="danger" @click="delInfo()">删除</el-button>
						<download-excel v-if="$check_option('/meteorological_data/table','import_db')" class="export-excel-wrapper" :data="DetailsForm" :fields="json_fields" name="数据导入表格.xls" >
							<el-button type="success">下载导入文档</el-button>
						</download-excel>
						<el-upload v-if="$check_option('/meteorological_data/table','import_db')" action accept = ".xlsx, .xls" :auto-upload="false" :show-file-list="false" :on-change="handle_import">
							<el-button type="primary">导入</el-button>
						</el-upload>
					</el-form-item>
				</el-col>

			</el-row>
		</el-form>
		<el-table :data="list" @selection-change="selectionChange" @sort-change="$sortChange" style="width: 100%" id="dataTable">
			<el-table-column fixed type="selection" tooltip-effect="dark" width="55">
			</el-table-column>
				<el-table-column prop="hohhot" @sort-change="$sortChange" label="呼和浩特"
				v-if="user_group == '管理员' || $check_field('get','hohhot')" min-width="200">
					</el-table-column>
					<el-table-column prop="year" @sort-change="$sortChange" label="年"
				v-if="user_group == '管理员' || $check_field('get','year')" min-width="200">
					</el-table-column>
					<el-table-column prop="month" @sort-change="$sortChange" label="月"
				v-if="user_group == '管理员' || $check_field('get','month')" min-width="200">
					</el-table-column>
					<el-table-column prop="day" @sort-change="$sortChange" label="日"
				v-if="user_group == '管理员' || $check_field('get','day')" min-width="200">
					</el-table-column>
					<el-table-column prop="precipitation" @sort-change="$sortChange" label="降水量"
				v-if="user_group == '管理员' || $check_field('get','precipitation')" min-width="200">
					</el-table-column>
					<el-table-column prop="extreme_wind_speed" @sort-change="$sortChange" label="极大风速"
				v-if="user_group == '管理员' || $check_field('get','extreme_wind_speed')" min-width="200">
					</el-table-column>
					<el-table-column prop="a_direction_of_extreme_wind_speed" @sort-change="$sortChange" label="极大风速的风向"
				v-if="user_group == '管理员' || $check_field('get','a_direction_of_extreme_wind_speed')" min-width="200">
					</el-table-column>
					<el-table-column prop="average_air_pressure" @sort-change="$sortChange" label="平均气压"
				v-if="user_group == '管理员' || $check_field('get','average_air_pressure')" min-width="200">
					</el-table-column>
					<el-table-column prop="average_wind_speed" @sort-change="$sortChange" label="平均风速"
				v-if="user_group == '管理员' || $check_field('get','average_wind_speed')" min-width="200">
					</el-table-column>
					<el-table-column prop="average_temperature" @sort-change="$sortChange" label="平均气温"
				v-if="user_group == '管理员' || $check_field('get','average_temperature')" min-width="200">
					</el-table-column>
					<el-table-column prop="average_water_pressure" @sort-change="$sortChange" label="平均水气压"
				v-if="user_group == '管理员' || $check_field('get','average_water_pressure')" min-width="200">
					</el-table-column>
					<el-table-column prop="average_relative_humidity" @sort-change="$sortChange" label="平均相对湿度"
				v-if="user_group == '管理员' || $check_field('get','average_relative_humidity')" min-width="200">
					</el-table-column>
					<el-table-column prop="sunlight_hours" @sort-change="$sortChange" label="日照时数"
				v-if="user_group == '管理员' || $check_field('get','sunlight_hours')" min-width="200">
					</el-table-column>
					<el-table-column prop="minimum_air_pressure" @sort-change="$sortChange" label="最低气压"
				v-if="user_group == '管理员' || $check_field('get','minimum_air_pressure')" min-width="200">
					</el-table-column>
					<el-table-column prop="minimum_temperature" @sort-change="$sortChange" label="最低气温"
				v-if="user_group == '管理员' || $check_field('get','minimum_temperature')" min-width="200">
					</el-table-column>
					<el-table-column prop="maximum_air_pressure" @sort-change="$sortChange" label="最高气压"
				v-if="user_group == '管理员' || $check_field('get','maximum_air_pressure')" min-width="200">
					</el-table-column>
					<el-table-column prop="maximum_temperature" @sort-change="$sortChange" label="最高气温"
				v-if="user_group == '管理员' || $check_field('get','maximum_temperature')" min-width="200">
					</el-table-column>
					<el-table-column prop="maximum_wind_speed" @sort-change="$sortChange" label="最大风速"
				v-if="user_group == '管理员' || $check_field('get','maximum_wind_speed')" min-width="200">
					</el-table-column>
					<el-table-column prop="wind_direction_of_maximum_wind_speed" @sort-change="$sortChange" label="最大风速的风向"
				v-if="user_group == '管理员' || $check_field('get','wind_direction_of_maximum_wind_speed')" min-width="200">
					</el-table-column>
					<el-table-column prop="minimum_relative_humidity" @sort-change="$sortChange" label="最小相对湿度"
				v-if="user_group == '管理员' || $check_field('get','minimum_relative_humidity')" min-width="200">
					</el-table-column>
	



            <el-table-column sortable prop="create_time" label="创建时间" min-width="200">
                <template slot-scope="scope">
                	{{ $toTime(scope.row["create_time"],"yyyy-MM-dd hh:mm:ss") }}
                </template>
            </el-table-column>

			<el-table-column sortable prop="update_time" label="更新时间" min-width="200">
                <template slot-scope="scope">
                	{{ $toTime(scope.row["update_time"],"yyyy-MM-dd hh:mm:ss") }}
                </template>
			</el-table-column>







			<el-table-column fixed="right" label="操作" min-width="120" v-if="user_group == '管理员' || $check_action('/meteorological_data/table','set') || $check_action('/meteorological_data/view','set') || $check_action('/meteorological_data/view','get') || $check_action('//table','add') || $check_action('//view','add')" >


				<template slot-scope="scope">
					<router-link class="el-button el-button--small is-plain el-button--success" style="margin: 5px !important;"
					v-if="user_group == '管理员' || $check_action('/meteorological_data/table','set') || $check_action('/meteorological_data/view','set') || $check_action('/meteorological_data/view','get')"
						:to="'./view?' + field + '=' + scope.row[field]"
						 size="small">
						<span>详情</span>
					</router-link>
						<router-link v-if="user_group == '管理员' || $check_comment('/meteorological_data/table')" class="el-button el-button--small is-plain el-button--primary"
								  :to="'../comment/table?size=10&page=1&source_table=meteorological_data&source_field=' + field + '&source_id=' + scope.row[field]" size="small">
					查看评论
					</router-link>
					</template>
			</el-table-column>

		</el-table>

		<!-- 分页器 -->
		<div class="mt text_center">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
				:current-page="query.page" :page-sizes="[7, 10, 30, 100]" :page-size="query.size"
				layout="total, sizes, prev, pager, next, jumper" :total="count">
			</el-pagination>
		</div>
		<!-- /分页器 -->

																				
		<div class="modal_wrap" v-if="showModal">
			<div class="modal_box">
				<!-- <div class="modal_box_close" @click="closeModal">X</div> -->
				<p class="modal_box_title">重要提醒</p>
				<p class="modal_box_text">当前有数据达到预警值！</p>
				<div class="btn_box">
					<span @click="closeModal">取消</span>
					<span @click="closeModal">确定</span>
				</div>
			</div>
		</div>


	</el-main>
</template>
<script>
	import mixin from "@/mixins/page.js";
	import * as XLSX from 'xlsx/xlsx.mjs'

	export default {
		mixins: [mixin],
		data() {
			return {
				// 弹框
				showModal: false,
				// 获取数据地址
				url_get_list: "~/api/meteorological_data/get_list?like=0",
				url_del: "~/api/meteorological_data/del?",

				// 字段ID
				field: "meteorological_data_id",

				// 查询
				query: {
					"size": 7,
					"page": 1,
									"year": "",
											"month": "",
																									"login_time": "",
					"create_time": "",
					"orderby": `create_time desc`
				},

				// 数据
				list: [],
				json_fields: {
							"呼和浩特":'hohhot',
						"年":'year',
						"月":'month',
						"日":'day',
						"降水量":'precipitation',
						"极大风速":'extreme_wind_speed',
						"极大风速的风向":'a_direction_of_extreme_wind_speed',
						"平均气压":'average_air_pressure',
						"平均风速":'average_wind_speed',
						"平均气温":'average_temperature',
						"平均水气压":'average_water_pressure',
						"平均相对湿度":'average_relative_humidity',
						"日照时数":'sunlight_hours',
						"最低气压":'minimum_air_pressure',
						"最低气温":'minimum_temperature',
						"最高气压":'maximum_air_pressure',
						"最高气温":'maximum_temperature',
						"最大风速":'maximum_wind_speed',
						"最大风速的风向":'wind_direction_of_maximum_wind_speed',
						"最小相对湿度":'minimum_relative_humidity',
					},
				DetailsForm: [
					{
								hohhot:"文本类型",
							year:"文本类型",
							month:"文本类型",
							day:"文本类型",
							precipitation:"文本类型",
							extreme_wind_speed:"文本类型",
							a_direction_of_extreme_wind_speed:"文本类型",
							average_air_pressure:"文本类型",
							average_wind_speed:"文本类型",
							average_temperature:"文本类型",
							average_water_pressure:"文本类型",
							average_relative_humidity:"文本类型",
							sunlight_hours:"文本类型",
							minimum_air_pressure:"文本类型",
							minimum_temperature:"文本类型",
							maximum_air_pressure:"文本类型",
							maximum_temperature:"文本类型",
							maximum_wind_speed:"文本类型",
							wind_direction_of_maximum_wind_speed:"文本类型",
							minimum_relative_humidity:"文本类型",
						},
				],
																																																															}
		},
		methods: {
			// 关闭弹框
			closeModal(){
				this.showModal = false;
				},


																																								


	/**
	 * 导入
	 */
	readFile(file){//文件读取
		return new Promise(resolve => {
			let reader = new FileReader();
			reader.readAsBinaryString(file);//以二进制的方式读取
			reader.onload = ev =>{
				resolve(ev.target.result);
			}
		})
	},
	async handle_import(ev){
		let file = ev.raw;
		console.log(file)
		if(!file){
			console.log("文件打开失败")
			return ;
		}else{
			let data = await this.readFile(file);
			let workbook = XLSX.read(data,{ type: "binary"});//解析二进制格式数据
			let worksheet = workbook.Sheets[workbook.SheetNames[0]];//获取第一个Sheet
			let result = XLSX.utils.sheet_to_json(worksheet);//json数据格式
			result.forEach((item) => {
				// 将中文的键名替换成英文的
				for (let k in this.json_fields) {
					let newKey = this.json_fields[k];
					if (newKey) {
						item[newKey] = item[k];
						delete item[k];
					}
				}
			});
			let _this = this;
				for (let i=0;i<result.length;i++){
				let url = "~/api/meteorological_data/add?";
				await this.$post(url, result[i], function (json, status) {
					console.log("提交结果：", json);
					if (json.result) {
						_this.$toast("操作成功", 'success');
					} else if (json.error) {
						_this.$toast(json.error.message, 'danger');
					}
				});
			}
			}
	},

																																											deleteRow(index, rows) {
				rows.splice(index, 1);
			}

		},
		created() {
																																										}
	}
</script>

<style type="text/css">
	.bg {
		background: white;
	}

	.form.p_4 {
		padding: 1rem;
	}

	.form .el-input {
		width: initial;
	}

	.mt {
		margin-top: 1rem;
	}

	.text_center {
		text-align: center;
	}

	.float-right {
		float: right;
	}


	.modal_wrap{
		width: 100vw;
		height: 100vh;
		position: fixed;
		top: 0;
		left: 0;
		background: rgba(0,0,0,0.5);
		z-index: 9999999999;
	}
	.modal_wrap .modal_box{
		width: 400px;
		height: 200px;
		background: url("../../assets/modal_bg.jpg") no-repeat center;
		background-size: cover;
		position: absolute;
		top: 50%;
		left: 50%;
		margin-left: -200px;
		margin-top: -100px;
		border-radius: 10px;
		}
	.modal_wrap .modal_box .modal_box_close{
		font-size: 20px;
		position: absolute;
		top: 10px;
		right: 10px;
		cursor: pointer;
		}
	.modal_wrap .modal_box .modal_box_title{
	  text-align: center;
    font-size: 18px;
    margin: 16px auto;
    color: #fff;
    border-bottom: 1px solid rgba(117, 116, 116,0.5);
    padding-bottom: 16px;
    width: 356px;
		}
	.modal_wrap .modal_box .modal_box_text{
			text-align: center;
		font-size: 15px;
		color: #fff;
		margin-top: 25px;
		}
	.modal_wrap .modal_box .btn_box{
		display: flex;
		flex-direction: row;
		justify-content: center;
		margin-top: 42px;
		}
			.modal_wrap .modal_box .btn_box span{
				display: inline-block;
				width: 80px;
				height: 30px;
				line-height: 30px;
				text-align: center;
				border: 1px solid #ccc;
				font-size: 14px;
				cursor: pointer;
				color: #fff;
			}
	.modal_wrap .modal_box .btn_box span:nth-child(2){
		background: #409EFF;
		color: #fff;
		border-color: #409EFF;
		margin-left: 15px;
	}
</style>
