<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','hohhot') || $check_field('add','hohhot') || $check_field('set','hohhot')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="呼和浩特" prop="hohhot">
												<el-input id="hohhot" v-model="form['hohhot']" placeholder="请输入呼和浩特"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','hohhot')) || (!form['meteorological_data_id'] && $check_field('add','hohhot'))" :disabled="disabledObj['hohhot_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','hohhot')">{{form['hohhot']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','year') || $check_field('add','year') || $check_field('set','year')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="年" prop="year">
												<el-input id="year" v-model="form['year']" placeholder="请输入年"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','year')) || (!form['meteorological_data_id'] && $check_field('add','year'))" :disabled="disabledObj['year_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','year')">{{form['year']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','month') || $check_field('add','month') || $check_field('set','month')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="月" prop="month">
												<el-input id="month" v-model="form['month']" placeholder="请输入月"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','month')) || (!form['meteorological_data_id'] && $check_field('add','month'))" :disabled="disabledObj['month_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','month')">{{form['month']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','day') || $check_field('add','day') || $check_field('set','day')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="日" prop="day">
												<el-input id="day" v-model="form['day']" placeholder="请输入日"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','day')) || (!form['meteorological_data_id'] && $check_field('add','day'))" :disabled="disabledObj['day_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','day')">{{form['day']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','precipitation') || $check_field('add','precipitation') || $check_field('set','precipitation')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="降水量" prop="precipitation">
												<el-input id="precipitation" v-model="form['precipitation']" placeholder="请输入降水量"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','precipitation')) || (!form['meteorological_data_id'] && $check_field('add','precipitation'))" :disabled="disabledObj['precipitation_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','precipitation')">{{form['precipitation']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','extreme_wind_speed') || $check_field('add','extreme_wind_speed') || $check_field('set','extreme_wind_speed')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="极大风速" prop="extreme_wind_speed">
												<el-input id="extreme_wind_speed" v-model="form['extreme_wind_speed']" placeholder="请输入极大风速"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','extreme_wind_speed')) || (!form['meteorological_data_id'] && $check_field('add','extreme_wind_speed'))" :disabled="disabledObj['extreme_wind_speed_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','extreme_wind_speed')">{{form['extreme_wind_speed']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','a_direction_of_extreme_wind_speed') || $check_field('add','a_direction_of_extreme_wind_speed') || $check_field('set','a_direction_of_extreme_wind_speed')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="极大风速的风向" prop="a_direction_of_extreme_wind_speed">
												<el-input id="a_direction_of_extreme_wind_speed" v-model="form['a_direction_of_extreme_wind_speed']" placeholder="请输入极大风速的风向"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','a_direction_of_extreme_wind_speed')) || (!form['meteorological_data_id'] && $check_field('add','a_direction_of_extreme_wind_speed'))" :disabled="disabledObj['a_direction_of_extreme_wind_speed_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','a_direction_of_extreme_wind_speed')">{{form['a_direction_of_extreme_wind_speed']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','average_air_pressure') || $check_field('add','average_air_pressure') || $check_field('set','average_air_pressure')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="平均气压" prop="average_air_pressure">
												<el-input id="average_air_pressure" v-model="form['average_air_pressure']" placeholder="请输入平均气压"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','average_air_pressure')) || (!form['meteorological_data_id'] && $check_field('add','average_air_pressure'))" :disabled="disabledObj['average_air_pressure_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','average_air_pressure')">{{form['average_air_pressure']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','average_wind_speed') || $check_field('add','average_wind_speed') || $check_field('set','average_wind_speed')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="平均风速" prop="average_wind_speed">
												<el-input id="average_wind_speed" v-model="form['average_wind_speed']" placeholder="请输入平均风速"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','average_wind_speed')) || (!form['meteorological_data_id'] && $check_field('add','average_wind_speed'))" :disabled="disabledObj['average_wind_speed_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','average_wind_speed')">{{form['average_wind_speed']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','average_temperature') || $check_field('add','average_temperature') || $check_field('set','average_temperature')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="平均气温" prop="average_temperature">
												<el-input id="average_temperature" v-model="form['average_temperature']" placeholder="请输入平均气温"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','average_temperature')) || (!form['meteorological_data_id'] && $check_field('add','average_temperature'))" :disabled="disabledObj['average_temperature_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','average_temperature')">{{form['average_temperature']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','average_water_pressure') || $check_field('add','average_water_pressure') || $check_field('set','average_water_pressure')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="平均水气压" prop="average_water_pressure">
												<el-input id="average_water_pressure" v-model="form['average_water_pressure']" placeholder="请输入平均水气压"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','average_water_pressure')) || (!form['meteorological_data_id'] && $check_field('add','average_water_pressure'))" :disabled="disabledObj['average_water_pressure_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','average_water_pressure')">{{form['average_water_pressure']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','average_relative_humidity') || $check_field('add','average_relative_humidity') || $check_field('set','average_relative_humidity')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="平均相对湿度" prop="average_relative_humidity">
												<el-input id="average_relative_humidity" v-model="form['average_relative_humidity']" placeholder="请输入平均相对湿度"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','average_relative_humidity')) || (!form['meteorological_data_id'] && $check_field('add','average_relative_humidity'))" :disabled="disabledObj['average_relative_humidity_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','average_relative_humidity')">{{form['average_relative_humidity']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','sunlight_hours') || $check_field('add','sunlight_hours') || $check_field('set','sunlight_hours')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="日照时数" prop="sunlight_hours">
												<el-input id="sunlight_hours" v-model="form['sunlight_hours']" placeholder="请输入日照时数"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','sunlight_hours')) || (!form['meteorological_data_id'] && $check_field('add','sunlight_hours'))" :disabled="disabledObj['sunlight_hours_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','sunlight_hours')">{{form['sunlight_hours']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','minimum_air_pressure') || $check_field('add','minimum_air_pressure') || $check_field('set','minimum_air_pressure')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="最低气压" prop="minimum_air_pressure">
												<el-input id="minimum_air_pressure" v-model="form['minimum_air_pressure']" placeholder="请输入最低气压"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','minimum_air_pressure')) || (!form['meteorological_data_id'] && $check_field('add','minimum_air_pressure'))" :disabled="disabledObj['minimum_air_pressure_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','minimum_air_pressure')">{{form['minimum_air_pressure']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','minimum_temperature') || $check_field('add','minimum_temperature') || $check_field('set','minimum_temperature')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="最低气温" prop="minimum_temperature">
												<el-input id="minimum_temperature" v-model="form['minimum_temperature']" placeholder="请输入最低气温"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','minimum_temperature')) || (!form['meteorological_data_id'] && $check_field('add','minimum_temperature'))" :disabled="disabledObj['minimum_temperature_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','minimum_temperature')">{{form['minimum_temperature']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','maximum_air_pressure') || $check_field('add','maximum_air_pressure') || $check_field('set','maximum_air_pressure')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="最高气压" prop="maximum_air_pressure">
												<el-input id="maximum_air_pressure" v-model="form['maximum_air_pressure']" placeholder="请输入最高气压"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','maximum_air_pressure')) || (!form['meteorological_data_id'] && $check_field('add','maximum_air_pressure'))" :disabled="disabledObj['maximum_air_pressure_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','maximum_air_pressure')">{{form['maximum_air_pressure']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','maximum_temperature') || $check_field('add','maximum_temperature') || $check_field('set','maximum_temperature')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="最高气温" prop="maximum_temperature">
												<el-input id="maximum_temperature" v-model="form['maximum_temperature']" placeholder="请输入最高气温"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','maximum_temperature')) || (!form['meteorological_data_id'] && $check_field('add','maximum_temperature'))" :disabled="disabledObj['maximum_temperature_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','maximum_temperature')">{{form['maximum_temperature']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','maximum_wind_speed') || $check_field('add','maximum_wind_speed') || $check_field('set','maximum_wind_speed')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="最大风速" prop="maximum_wind_speed">
												<el-input id="maximum_wind_speed" v-model="form['maximum_wind_speed']" placeholder="请输入最大风速"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','maximum_wind_speed')) || (!form['meteorological_data_id'] && $check_field('add','maximum_wind_speed'))" :disabled="disabledObj['maximum_wind_speed_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','maximum_wind_speed')">{{form['maximum_wind_speed']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','wind_direction_of_maximum_wind_speed') || $check_field('add','wind_direction_of_maximum_wind_speed') || $check_field('set','wind_direction_of_maximum_wind_speed')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="最大风速的风向" prop="wind_direction_of_maximum_wind_speed">
												<el-input id="wind_direction_of_maximum_wind_speed" v-model="form['wind_direction_of_maximum_wind_speed']" placeholder="请输入最大风速的风向"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','wind_direction_of_maximum_wind_speed')) || (!form['meteorological_data_id'] && $check_field('add','wind_direction_of_maximum_wind_speed'))" :disabled="disabledObj['wind_direction_of_maximum_wind_speed_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','wind_direction_of_maximum_wind_speed')">{{form['wind_direction_of_maximum_wind_speed']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','minimum_relative_humidity') || $check_field('add','minimum_relative_humidity') || $check_field('set','minimum_relative_humidity')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="最小相对湿度" prop="minimum_relative_humidity">
												<el-input id="minimum_relative_humidity" v-model="form['minimum_relative_humidity']" placeholder="请输入最小相对湿度"
							  v-if="user_group === '管理员' || (form['meteorological_data_id'] && $check_field('set','minimum_relative_humidity')) || (!form['meteorological_data_id'] && $check_field('add','minimum_relative_humidity'))" :disabled="disabledObj['minimum_relative_humidity_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','minimum_relative_humidity')">{{form['minimum_relative_humidity']}}</div>
											</el-form-item>
			</el-col>
					
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "meteorological_data_id",
				url_add: "~/api/meteorological_data/add?",
				url_set: "~/api/meteorological_data/set?",
				url_get_obj: "~/api/meteorological_data/get_obj?",
				url_upload: "~/api/meteorological_data/upload?",

				query: {
					"meteorological_data_id": 0,
				},

				form: {
								"hohhot":  '', // 呼和浩特
										"year":  '', // 年
										"month":  '', // 月
										"day":  '', // 日
										"precipitation":  '', // 降水量
										"extreme_wind_speed":  '', // 极大风速
										"a_direction_of_extreme_wind_speed":  '', // 极大风速的风向
										"average_air_pressure":  '', // 平均气压
										"average_wind_speed":  '', // 平均风速
										"average_temperature":  '', // 平均气温
										"average_water_pressure":  '', // 平均水气压
										"average_relative_humidity":  '', // 平均相对湿度
										"sunlight_hours":  '', // 日照时数
										"minimum_air_pressure":  '', // 最低气压
										"minimum_temperature":  '', // 最低气温
										"maximum_air_pressure":  '', // 最高气压
										"maximum_temperature":  '', // 最高气温
										"maximum_wind_speed":  '', // 最大风速
										"wind_direction_of_maximum_wind_speed":  '', // 最大风速的风向
										"minimum_relative_humidity":  '', // 最小相对湿度
											"meteorological_data_id": 0, // ID
						
				},
				disabledObj:{
								"hohhot_isDisabled": false,
										"year_isDisabled": false,
										"month_isDisabled": false,
										"day_isDisabled": false,
										"precipitation_isDisabled": false,
										"extreme_wind_speed_isDisabled": false,
										"a_direction_of_extreme_wind_speed_isDisabled": false,
										"average_air_pressure_isDisabled": false,
										"average_wind_speed_isDisabled": false,
										"average_temperature_isDisabled": false,
										"average_water_pressure_isDisabled": false,
										"average_relative_humidity_isDisabled": false,
										"sunlight_hours_isDisabled": false,
										"minimum_air_pressure_isDisabled": false,
										"minimum_temperature_isDisabled": false,
										"maximum_air_pressure_isDisabled": false,
										"maximum_temperature_isDisabled": false,
										"maximum_wind_speed_isDisabled": false,
										"wind_direction_of_maximum_wind_speed_isDisabled": false,
										"minimum_relative_humidity_isDisabled": false,
										},

	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
			
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
																																												$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																																																												


			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																																																																		return msg;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/meteorological_data/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/meteorological_data/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/meteorological_data/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/meteorological_data/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/meteorological_data/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
																																										},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
