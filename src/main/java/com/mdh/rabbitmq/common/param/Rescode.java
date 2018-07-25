package com.mdh.rabbitmq.common.param;


public class Rescode {

	/** 交易成功 */
	public static final String SUCCESS = "0000";
	/** 交易失败 */
	public static final String FAILURE = "9999";
	
	/**数据库操作出错*/
	public static final String COM_9998 = "9998";
	/** 系统错误(system error)* */
	public static final String COM_9997 = "9997";
	/** 不合法的请求格式* */
	public static final String COM_0100 = "0100";
	/** 参数错误(invalid parameter)* */
	public static final String COM_0101 = "0101";
	/** 不合法的交易码* */
	public static final String COM_0102 = "0102";
	/** 请求信息数据签名验证失败 */
	public static final String COM_0103 = "0103";

	/** 支付码无效* */
	public static final String TRAN_1001 = "1001";
	/** =支付码已经失效* */
	public static final String TRAN_1002 = "1002";
	/** 支付密码错误* */
	public static final String TRAN_1003 = "1003";
	/** 账户余额不足* */
	public static final String TRAN_1004 = "1004";
	/** 生成流水出错* */
	public static final String TRAN_1005 = "1005";
	/** 冲正金额不一致* */
	public static final String TRAN_1006 = "1006";
	/** 撤销金额不一致* */
	public static final String TRAN_1007 = "1007";
	/** 退款金额不一致* */
	public static final String TRAN_1008 = "1008";
	/** 仅允许撤销当日的交易* */
	public static final String TRAN_1009 = "1009";
	/** 此交易流水号不存在* */
	public static final String TRAN_1010 = "1010";
	/** 外部系统订单号重复* */
	public static final String TRAN_1011 = "1011";
	/** 原订单流水不存在* */
	public static final String TRAN_1012 = "1012";
	/**不能重复设置支付密码* */
	public static final String TRAN_1013 = "1013";
	/** 原订单已被冲正* */
	public static final String TRAN_1014 = "1014";
	/** 原订单已被撤销* */
	public static final String TRAN_1015 = "1015";
	/** 原订单已被退货* */
	public static final String TRAN_1016 = "1016";
	/**仅允许撤销当天的交易* */
	public static final String TRAN_1017 = "1017";
	/**openid不能为空* */
	public static final String TRAN_1018 = "1018";
	/** 不合法的code值* */
	public static final String TRAN_1019 = "1019";
	/**卡片已经领取成功* */
	public static final String TRAN_1020 = "1020";
	/**旧支付密码错误* */
	public static final String TRAN_1021 = "1021";
	/**转赠-超过领取时间，不允许领取* */
	public static final String TRAN_1022 = "1022";
	/**不能领取自己转赠的礼品卡**/
	public static final String TRAN_1023 = "1023";
	/**转赠中，不能再次转赠**/
	public static final String TRAN_1024 = "1024";
	/**赠送人和持卡人不一致**/
	public static final String TRAN_1025 = "1025";
	/**实体卡余额有误，不能充值**/
	public static final String TRAN_1026 = "1026";
	/**实体卡没有余额，不能充值**/
	public static final String TRAN_1027 = "1027";
	/**实名登记，不能重复登记实名信息**/
	public static final String TRAN_1028 = "1028";
	/**用户未注册,不能申请贷款**/
	public static final String TRAN_1029 = "1029";
	/**当前用户账户状态不可用**/
	public static final String TRAN_1030 = "1030";
	/**手机号已被占用**/
	public static final String TRAN_1031 = "1031";
	/**支付请求流水号重复**/
	public static final String TRAN_1032 = "1032";
	/**不在系统服务时间**/
	public static final String TRAN_1033 = "1033";
	/**请实名认证后再上传文件**/
	public static final String TRAN_1034 = "1034";
	/**图片正在审核中**/
	public static final String TRAN_1035 = "1035";
	/**已上传，无需重复上传图片**/
	public static final String TRAN_1036 = "1036";
	/**超出当天的密码错误次数上限，账户已被暂时冻结，次日解冻**/
	public static final String TRAN_1037 = "1037";
	/**更新账户余额异常**/
	public static final String TRAN_1038 = "1038";
	/**更新账户状态异常**/
	public static final String TRAN_1039 = "1039";
	/** 没有和该金额匹配的订单* */
	public static final String TRAN_1040 = "1040";
	/** 该订单状态不允许退款* */
	public static final String TRAN_1041 = "1041";
	/**该商场不受理此卡* */
	public static final String TRAN_1042 = "1042";
	/** 卡状态无效，不能支付 */
	public static final String TRAN_1043 = "1043";
	/**账户已被止付，请联系客服人员 */
	public static final String TRAN_1044 = "1044";
	/**超过单笔支付最大限额，支付失败 */
	public static final String TRAN_1045 = "1045";
	/**超过单日支付累积上限金额，支付失败*/
	public static final String TRAN_1046 = "1046";

}
