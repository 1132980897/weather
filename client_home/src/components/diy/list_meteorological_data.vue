<template>
	<div class="diy_home diy_list diy_meteorological_data" id="diy_meteorological_data_list">
		<!-- 列表 -->
		<div class="diy_view_list list list-x" v-if="show">
			<router-link class="diy_card goods diy_list_box_wrap" v-for="(o, i) in list" :key="i"
				:to="'/meteorological_data/details?meteorological_data_id=' + o['meteorological_data_id']">
				<!-- 图片 -->
				<div class="diy_list_img_box" v-if="imgList.length" >
					<div class="diy_row" v-for="(item,index) in imgList" :key="item+index" v-show="$check_field('get',item.name,'/meteorological_data/details') && +item.is_img_list">
						<div class="diy_title diy_list_img_title">
							<span>{{item.title}}:</span>
						</div>
						<div class="diy_field diy_img">
							<img :src="$fullUrl(o[item.name])" style="width:100%;height:100%" />
						</div>
					</div>
				</div>
				<!-- 内容 -->
				<div class="diy_list_item_box">
					<div class="diy_list_item_content" v-for="(item,index) in showItemList" :key="item+index">
						<div class="diy_row" :class="{[item.name]:true}" v-if="$check_field('get',item.name,'/meteorological_data/details') && +item.is_img_list">
							<div class="diy_title">
								<span>{{item.title}}:</span>
							</div>
							<div class="diy_field diy_text">
								<span v-if="item.type == 'UID'" v-text="get_user_name(item.name,o[item.name])"></span>
								<span v-else-if="item.type == '日期'" v-text="$toTime(o[item.name],'yyyy-MM-dd')"></span>
								<span v-else-if="item.type == '时间'" v-text="$toTime(o[item.name],'hh:mm:ss')"></span>
								<span v-else-if="item.type == '日长'" v-text="$toTime(o[item.name],'yyyy-MM-dd hh:mm:ss')"></span>
								<span v-else v-text="o[item.name]"></span>
							</div>
						</div>
					</div>
				</div>
			</router-link>
		</div>
		<!-- 表格 -->
		<div class="diy_view_table" v-else>
			<table class="diy_table">
				<tr class="diy_row">
						<th class="diy_title" v-if="$check_field('get','hohhot')">
						呼和浩特
					</th>
							<th class="diy_title" v-if="$check_field('get','year')">
						年
					</th>
							<th class="diy_title" v-if="$check_field('get','month')">
						月
					</th>
							<th class="diy_title" v-if="$check_field('get','day')">
						日
					</th>
							<th class="diy_title" v-if="$check_field('get','precipitation')">
						降水量
					</th>
							<th class="diy_title" v-if="$check_field('get','extreme_wind_speed')">
						极大风速
					</th>
							<th class="diy_title" v-if="$check_field('get','a_direction_of_extreme_wind_speed')">
						极大风速的风向
					</th>
							<th class="diy_title" v-if="$check_field('get','average_air_pressure')">
						平均气压
					</th>
							<th class="diy_title" v-if="$check_field('get','average_wind_speed')">
						平均风速
					</th>
							<th class="diy_title" v-if="$check_field('get','average_temperature')">
						平均气温
					</th>
							<th class="diy_title" v-if="$check_field('get','average_water_pressure')">
						平均水气压
					</th>
							<th class="diy_title" v-if="$check_field('get','average_relative_humidity')">
						平均相对湿度
					</th>
							<th class="diy_title" v-if="$check_field('get','sunlight_hours')">
						日照时数
					</th>
							<th class="diy_title" v-if="$check_field('get','minimum_air_pressure')">
						最低气压
					</th>
							<th class="diy_title" v-if="$check_field('get','minimum_temperature')">
						最低气温
					</th>
							<th class="diy_title" v-if="$check_field('get','maximum_air_pressure')">
						最高气压
					</th>
							<th class="diy_title" v-if="$check_field('get','maximum_temperature')">
						最高气温
					</th>
							<th class="diy_title" v-if="$check_field('get','maximum_wind_speed')">
						最大风速
					</th>
							<th class="diy_title" v-if="$check_field('get','wind_direction_of_maximum_wind_speed')">
						最大风速的风向
					</th>
							<th class="diy_title" v-if="$check_field('get','minimum_relative_humidity')">
						最小相对湿度
					</th>
					</tr>
				<tr class="diy_row" v-for="(o,i) in list" :key="o+i">
						<td class="diy_field diy_text" v-if="$check_field('get','hohhot')">
						<span>
							{{ o["hohhot"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','year')">
						<span>
							{{ o["year"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','month')">
						<span>
							{{ o["month"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','day')">
						<span>
							{{ o["day"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','precipitation')">
						<span>
							{{ o["precipitation"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','extreme_wind_speed')">
						<span>
							{{ o["extreme_wind_speed"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','a_direction_of_extreme_wind_speed')">
						<span>
							{{ o["a_direction_of_extreme_wind_speed"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','average_air_pressure')">
						<span>
							{{ o["average_air_pressure"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','average_wind_speed')">
						<span>
							{{ o["average_wind_speed"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','average_temperature')">
						<span>
							{{ o["average_temperature"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','average_water_pressure')">
						<span>
							{{ o["average_water_pressure"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','average_relative_humidity')">
						<span>
							{{ o["average_relative_humidity"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','sunlight_hours')">
						<span>
							{{ o["sunlight_hours"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','minimum_air_pressure')">
						<span>
							{{ o["minimum_air_pressure"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','minimum_temperature')">
						<span>
							{{ o["minimum_temperature"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','maximum_air_pressure')">
						<span>
							{{ o["maximum_air_pressure"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','maximum_temperature')">
						<span>
							{{ o["maximum_temperature"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','maximum_wind_speed')">
						<span>
							{{ o["maximum_wind_speed"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','wind_direction_of_maximum_wind_speed')">
						<span>
							{{ o["wind_direction_of_maximum_wind_speed"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','minimum_relative_humidity')">
						<span>
							{{ o["minimum_relative_humidity"] }}
						</span>
					</td>
					</tr>
			</table>
		</div>
	</div>
</template>

<script>
	export default {
		props: {
			list: {
				type: Array,
				default: function() {
					return [];
				},
			},
			show: {
				type: Boolean,
				default: function(){
					return true;
				}
			}
		},
		data() {
			return {
						imgList: [
						],
						itemList: [
								{
									title: "呼和浩特",
									name: "hohhot",
									type: "文本",
									is_img_list: "1"
								},
								{
									title: "年",
									name: "year",
									type: "文本",
									is_img_list: "1"
								},
								{
									title: "月",
									name: "month",
									type: "文本",
									is_img_list: "1"
								},
								{
									title: "日",
									name: "day",
									type: "文本",
									is_img_list: "1"
								},
								{
									title: "降水量",
									name: "precipitation",
									type: "文本",
									is_img_list: "1"
								},
								{
									title: "极大风速",
									name: "extreme_wind_speed",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "极大风速的风向",
									name: "a_direction_of_extreme_wind_speed",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "平均气压",
									name: "average_air_pressure",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "平均风速",
									name: "average_wind_speed",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "平均气温",
									name: "average_temperature",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "平均水气压",
									name: "average_water_pressure",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "平均相对湿度",
									name: "average_relative_humidity",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "日照时数",
									name: "sunlight_hours",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "最低气压",
									name: "minimum_air_pressure",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "最低气温",
									name: "minimum_temperature",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "最高气压",
									name: "maximum_air_pressure",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "最高气温",
									name: "maximum_temperature",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "最大风速",
									name: "maximum_wind_speed",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "最大风速的风向",
									name: "wind_direction_of_maximum_wind_speed",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "最小相对湿度",
									name: "minimum_relative_humidity",
									type: "文本",
									is_img_list: "0"
								},
						],
						richList: [
						],
																							};
		},
		methods: {
			get_user_name(name,id){
				var obj = null;
																								var ret = "";
				if(obj){
					ret = obj.nickname+"-"+obj.username;
					// if(obj.nickname){
					// 	ret = obj.nickname;
					// }
					// else{
					// 	ret = obj.username;
					// }
				}
				return ret;
			},
																						},
		created() {
																						},
		computed:{
			showItemList(){
				let arr = [];
				let _type = ["视频","音频","文件"];
				this.itemList.forEach(item => {
					if(_type.indexOf(item.type) === -1 && !!+item.is_img_list){
						arr.push(item)
					}
				})
				return arr.slice(0,4);
			}
		}
	};
</script>

<style scoped>
	.media {
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		flex-basis: 75%;
		min-height: 10rem;
	}

	.goods {
		display: flex;
		width: calc(25% - 1rem);
		margin: 0.5rem;
		padding: 0.5rem;
		flex-direction: column;
		justify-content: space-between;
		background-color: white;
		border-radius: 0.5rem;
	}

	.goods:hover {
		border: 0.2rem solid #909399;
		box-shadow: 0 0.1rem 0.3rem rgba(0, 0, 0, 0.15);
	}

	.goods:hover img {
		filter: blur(1px);
	}

	.price {
		font-size: 1rem;
		margin-right: 3px;
	}

	.price_ago {
		text-decoration: line-through;
		font-size: 0.5rem;
		color: #999;

	}

	.title {
		word-break: break-all;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
		font-weight: 700;
		padding: .25rem;
	}

	.icon_cart {
		color: #FF5722;
		float: right;
	}

	@media (max-width: 992px) {

		.goods {
			width: calc(33% - 1rem);
			;
		}

	}

	@media (max-width: 768px) {

		.goods {
			width: calc(50% - 1rem);
			;
		}

	}
</style>

