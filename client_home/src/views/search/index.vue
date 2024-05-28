<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>

				<!--{if filter.article}-->
				<!-- 文章搜索结果 -->
			  <list_result_search
				:list="result_article"
				title="气象文章"
				source_table="article"
			  ></list_result_search>
				<!--{/if}-->


									  <list_result_search
				v-if="$check_action('/registered_users/list', 'get')"
				:list="result_registered_users_full_name"
				title="注册用户姓名"
				source_table="registered_users"
			  ></list_result_search>
																		  <list_result_search
				v-if="$check_action('/message_board/list', 'get')"
				:list="result_message_board_full_name"
				title="留言板姓名"
				source_table="message_board"
			  ></list_result_search>
																		  <list_result_search
				v-if="$check_action('/meteorological_data/list', 'get')"
				:list="result_meteorological_data_year"
				title="气象数据年"
				source_table="meteorological_data"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/meteorological_data/list', 'get')"
				:list="result_meteorological_data_month"
				title="气象数据月"
				source_table="meteorological_data"
			  ></list_result_search>
																																																									</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
	  "result_article": [],
									"result_registered_users_full_name":[],
																		"result_message_board_full_name":[],
																		"result_meteorological_data_year":[],
								"result_meteorological_data_month":[],
																																																							};
  },
  methods: {
	/**
	 * 获取文章
	 */
	get_article() {
	  this.$get("~/api/article/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_article = json.result.list;
		}
	  });
	},

							/**
	 * 获取full_name
	 */
	get_registered_users_full_name(){
		let url = "~/api/registered_users/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "full_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_registered_users_full_name = json.result.list;
			result_registered_users_full_name.map(o => o.title = o['full_name'])
	  			this.result_registered_users_full_name = result_registered_users_full_name
		 	}
		});
	},
																/**
	 * 获取full_name
	 */
	get_message_board_full_name(){
		let url = "~/api/message_board/get_list?like=0";
					url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "full_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_message_board_full_name = json.result.list;
			result_message_board_full_name.map(o => o.title = o['full_name'])
	  			this.result_message_board_full_name = result_message_board_full_name
		 	}
		});
	},
																/**
	 * 获取year
	 */
	get_meteorological_data_year(){
		let url = "~/api/meteorological_data/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "year": this.query.word }, (json) => {
		  if (json.result) {
			var result_meteorological_data_year = json.result.list;
			result_meteorological_data_year.map(o => o.title = o['year'])
	  			this.result_meteorological_data_year = result_meteorological_data_year
		 	}
		});
	},
						/**
	 * 获取month
	 */
	get_meteorological_data_month(){
		let url = "~/api/meteorological_data/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "month": this.query.word }, (json) => {
		  if (json.result) {
			var result_meteorological_data_month = json.result.list;
			result_meteorological_data_month.map(o => o.title = o['month'])
	  			this.result_meteorological_data_month = result_meteorological_data_month
		 	}
		});
	},
																																																						
  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
	this.get_article();
								this.get_registered_users_full_name();
																	this.get_message_board_full_name();
																	this.get_meteorological_data_year();
							this.get_meteorological_data_month();
																																																						  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
	  this.get_article();
							  this.get_registered_users_full_name();
																  this.get_message_board_full_name();
																  this.get_meteorological_data_year();
						  this.get_meteorological_data_month();
																																																							},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>
