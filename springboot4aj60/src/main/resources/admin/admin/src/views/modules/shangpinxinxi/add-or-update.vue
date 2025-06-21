<template>
	<div class="addEdit-block" :style='{"padding":"30px 0 0 0"}' style="width: 100%;">
		<el-form
			:style='{"padding":"20px 0px 120px"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="140px"
		>
			<template >
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'" label="商品编号" prop="shangpinbianhao">
					<el-input v-model="ruleForm.shangpinbianhao" placeholder="商品编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-else-if="ruleForm.shangpinbianhao" label="商品编号" prop="shangpinbianhao">
					<el-input v-model="ruleForm.shangpinbianhao" placeholder="商品编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="商品名称" prop="shangpinmingcheng">
					<el-input v-model="ruleForm.shangpinmingcheng" placeholder="商品名称" clearable  :readonly="ro.shangpinmingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="商品名称" prop="shangpinmingcheng">
					<el-input v-model="ruleForm.shangpinmingcheng" placeholder="商品名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="select" v-if="type!='info'"  label="商品分类" prop="shangpinfenlei">
					<el-select :disabled="ro.shangpinfenlei" v-model="ruleForm.shangpinfenlei" placeholder="请选择商品分类" >
						<el-option
							v-for="(item,index) in shangpinfenleiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="商品分类" prop="shangpinfenlei">
					<el-input v-model="ruleForm.shangpinfenlei"
						placeholder="商品分类" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="规格" prop="guige">
					<el-input v-model="ruleForm.guige" placeholder="规格" clearable  :readonly="ro.guige"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="规格" prop="guige">
					<el-input v-model="ruleForm.guige" placeholder="规格" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="upload" v-if="type!='info' && !ro.tupian" label="图片" prop="tupian">
					<file-upload
						tip="点击上传图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.tupian?ruleForm.tupian:''"
						@change="tupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="upload" v-else-if="ruleForm.tupian" label="图片" prop="tupian">
					<img v-if="ruleForm.tupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.tupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="select" v-if="type!='info'"  label="新旧程度" prop="xinjiuchengdu">
					<el-select :disabled="ro.xinjiuchengdu" v-model="ruleForm.xinjiuchengdu" placeholder="请选择新旧程度" >
						<el-option
							v-for="(item,index) in xinjiuchengduOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="新旧程度" prop="xinjiuchengdu">
					<el-input v-model="ruleForm.xinjiuchengdu"
						placeholder="新旧程度" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="date" v-if="type!='info'" label="发布时间" prop="fabushijian">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.fabushijian" 
						type="date"
						:readonly="ro.fabushijian"
						placeholder="发布时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-else-if="ruleForm.fabushijian" label="发布时间" prop="fabushijian">
					<el-input v-model="ruleForm.fabushijian" placeholder="发布时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="用户账号" prop="yonghuzhanghao">
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" clearable  :readonly="ro.yonghuzhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="用户账号" prop="yonghuzhanghao">
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuxingming">
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" clearable  :readonly="ro.yonghuxingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="用户姓名" prop="yonghuxingming">
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="单限" prop="onelimittimes">
					<el-input v-model="ruleForm.onelimittimes" placeholder="单限" clearable  :readonly="ro.onelimittimes"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="单限" prop="onelimittimes">
					<el-input v-model="ruleForm.onelimittimes" placeholder="单限" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="库存" prop="alllimittimes">
					<el-input v-model="ruleForm.alllimittimes" placeholder="库存" clearable  :readonly="ro.alllimittimes"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="库存" prop="alllimittimes">
					<el-input v-model="ruleForm.alllimittimes" placeholder="库存" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="价格" prop="price">
					<el-input v-model="ruleForm.price" placeholder="价格" clearable  :readonly="ro.price"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="价格" prop="price">
					<el-input v-model="ruleForm.price" placeholder="价格" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-if="type!='info'"  label="商品详情" prop="shangpinxiangqing">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.shangpinxiangqing" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else-if="ruleForm.shangpinxiangqing" label="商品详情" prop="shangpinxiangqing">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.shangpinxiangqing"></span>
                </el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"40px","background":"rgba(27, 167, 166, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
				<el-button :style='{"border":"1px solid rgba(27, 167, 166, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"rgba(27, 167, 166, 1)","borderRadius":"40px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
				<el-button :style='{"border":"1px solid rgba(27, 167, 166, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"rgba(27, 167, 166, 1)","borderRadius":"40px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				shangpinbianhao : false,
				shangpinmingcheng : false,
				shangpinfenlei : false,
				guige : false,
				tupian : false,
				xinjiuchengdu : false,
				fabushijian : false,
				shangpinxiangqing : false,
				yonghuzhanghao : false,
				yonghuxingming : false,
				onelimittimes : false,
				alllimittimes : false,
				clicktime : false,
				clicknum : false,
				price : false,
			},
			
			
			ruleForm: {
				shangpinbianhao: this.getUUID(),
				shangpinmingcheng: '',
				shangpinfenlei: '',
				guige: '',
				tupian: '',
				xinjiuchengdu: '',
				fabushijian: '',
				shangpinxiangqing: '',
				yonghuzhanghao: '',
				yonghuxingming: '',
				onelimittimes: '-1',
				alllimittimes: '-1',
				clicktime: '',
				price: '',
			},
		
			shangpinfenleiOptions: [],
			xinjiuchengduOptions: [],
			
			rules: {
				shangpinbianhao: [
				],
				shangpinmingcheng: [
				],
				shangpinfenlei: [
				],
				guige: [
				],
				tupian: [
				],
				xinjiuchengdu: [
				],
				fabushijian: [
				],
				shangpinxiangqing: [
				],
				yonghuzhanghao: [
				],
				yonghuxingming: [
				],
				onelimittimes: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				alllimittimes: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				clicktime: [
				],
				clicknum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				price: [
					{ required: true, message: '价格不能为空', trigger: 'blur' },
					{ validator: validateNumber, trigger: 'blur' },
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
		this.ruleForm.fabushijian = this.getCurDate()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='shangpinbianhao'){
							this.ruleForm.shangpinbianhao = obj[o];
							this.ro.shangpinbianhao = true;
							continue;
						}
						if(o=='shangpinmingcheng'){
							this.ruleForm.shangpinmingcheng = obj[o];
							this.ro.shangpinmingcheng = true;
							continue;
						}
						if(o=='shangpinfenlei'){
							this.ruleForm.shangpinfenlei = obj[o];
							this.ro.shangpinfenlei = true;
							continue;
						}
						if(o=='guige'){
							this.ruleForm.guige = obj[o];
							this.ro.guige = true;
							continue;
						}
						if(o=='tupian'){
							this.ruleForm.tupian = obj[o];
							this.ro.tupian = true;
							continue;
						}
						if(o=='xinjiuchengdu'){
							this.ruleForm.xinjiuchengdu = obj[o];
							this.ro.xinjiuchengdu = true;
							continue;
						}
						if(o=='fabushijian'){
							this.ruleForm.fabushijian = obj[o];
							this.ro.fabushijian = true;
							continue;
						}
						if(o=='shangpinxiangqing'){
							this.ruleForm.shangpinxiangqing = obj[o];
							this.ro.shangpinxiangqing = true;
							continue;
						}
						if(o=='yonghuzhanghao'){
							this.ruleForm.yonghuzhanghao = obj[o];
							this.ro.yonghuzhanghao = true;
							continue;
						}
						if(o=='yonghuxingming'){
							this.ruleForm.yonghuxingming = obj[o];
							this.ro.yonghuxingming = true;
							continue;
						}
						if(o=='onelimittimes'){
							this.ruleForm.onelimittimes = obj[o];
							this.ro.onelimittimes = true;
							continue;
						}
						if(o=='alllimittimes'){
							this.ruleForm.alllimittimes = obj[o];
							this.ro.alllimittimes = true;
							continue;
						}
						if(o=='clicktime'){
							this.ruleForm.clicktime = obj[o];
							this.ro.clicktime = true;
							continue;
						}
						if(o=='clicknum'){
							this.ruleForm.clicknum = obj[o];
							this.ro.clicknum = true;
							continue;
						}
						if(o=='price'){
							this.ruleForm.price = obj[o];
							this.ro.price = true;
							continue;
						}
				}
				











				this.ruleForm.onelimittimes='-1'

				this.ruleForm.alllimittimes='-1'



			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(((json.yonghuzhanghao!=''&&json.yonghuzhanghao) || json.yonghuzhanghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yonghuzhanghao = json.yonghuzhanghao
						this.ro.yonghuzhanghao = true;
					}
					if(((json.yonghuxingming!=''&&json.yonghuxingming) || json.yonghuxingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yonghuxingming = json.yonghuxingming
						this.ro.yonghuxingming = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.$http({
				url: `option/shangpinfenlei/shangpinfenlei`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.shangpinfenleiOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
            this.xinjiuchengduOptions = "全新,九成新,七成新,其他".split(',')
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `shangpinxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.shangpinxiangqing = this.ruleForm.shangpinxiangqing.replace(reg,'../../../springboot4aj60/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {










	if(this.ruleForm.tupian!=null) {
		this.ruleForm.tupian = this.ruleForm.tupian.replace(new RegExp(this.$base.url,"g"),"");
	}





















var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "shangpinxinxi/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `shangpinxinxi/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.shangpinxinxiCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `shangpinxinxi/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.shangpinxinxiCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.shangpinxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    tupianUploadChange(fileUrls) {
	    this.ruleForm.tupian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #333;
	  	  width: 140px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 140px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 300px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
</style>
