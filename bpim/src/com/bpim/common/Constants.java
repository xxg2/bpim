package com.bpim.common;

/**
 * @author Zongming.Zhong
 * 
 */
public interface Constants {

	final static String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 编码格式
	 */
	final static String ENCODING_TYPE = "UTF-8";

	/**
	 * 密码最小长度
	 */
	final static int MIN_PASSWORD_LEN = 6;

	/**
	 * 用户在线最大超时时间（分钟）
	 */
	final static int USER_INVALIDATE_TIME = 60;

	/**
	 * 超级用户角色ID
	 */
	// final static int SUPER_ROLE_ID =
	// ConfigLoader.getInstance().getSuperRoleId();
	/**
	 * 默认监控用户组ID
	 */
	// final static int DEFAULT_MONITOR_GROUP_ID =
	// ConfigLoader.getInstance().getDefaultMonitorGroupId();
	/**
	 * 操作类型：创建
	 */
	final static int OPER_TYPE_CREATE = 1;

	/**
	 * 操作类型：修改
	 */
	final static int OPER_TYPE_MODIFY = 2;

	/**
	 * 操作类型：禁止
	 */
	final static int OPER_TYPE_FORBID = 3;

	/**
	 * 操作类型：恢复
	 */
	final static int OPER_TYPE_RESUME = 4;

	/**
	 * 操作类型：删除
	 */
	final static int OPER_TYPE_DELETE = 5;

	/**
	 * 操作类型：登录
	 */
	final static int OPER_TYPE_LOGIN = 6;

	/**
	 * 操作类型：登出
	 */
	final static int OPER_TYPE_LOGOUT = 7;

	/**
	 * 默认密码
	 */
	final static String PASSWORD_DEFAULT = "123456";

	/**
	 * 超级管理员角色编号
	 */
	final static int SUPER_ADMIN_ROLE_ID = 1;

	/**
	 * 用户级别的最大值
	 */
	final static int MAX_RANK_CODE = 100;

	/**
	 * 厂商标识最大长度
	 */
	final static int MAX_PROVIDER_CODE = 4;

	/**
	 * 拓扑图每个节点的高度
	 */
	final static int NODE_HEIGHT = 60;

	/**
	 * 拓扑图每个节点的宽度
	 */
	final static int NODE_WIDTH = 60;

	/**
	 * 拓扑图节点的X轴
	 */
	final static int NODE_X = 80;

	/**
	 * 拓扑图节点的y轴
	 */
	final static int NODE_Y = 20;

	final static String PROVIDER = "CSHP";

	final static String NEVER_CLEAR = "3";

	final static String TIME_POINT = "1";

	/**
	 * 起始session的索引序号
	 */
	final static String REC_SESSION_INDEX = "0";

	/**
	 * 需要获取的session信息的个数
	 */
	final static String REC_SESSION_NUM = "50";
	// ////////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////// 参数名称定义 ///////////////////////////////
	// ////////////////////////////////////////////////////////////////////////////
	/**
	 * 页码
	 */
	final static String PARA_PAGE_NO = "pn";

	/**
	 * 页面显示数据条数
	 */
	final static String PARA_PAGE_SIZE = "ps";

	/**
	 * ACTION参数名
	 */
	// final static String ACTION = "ac";
	/**
	 * 用户登录后保存用户id的参数名
	 */
	final static String LOGIN_USER_ID = "userid";

	/**
	 * 用户登录后保存用户名称的参数名
	 */
	final static String LOGIN_USER_NAME = "username";

	final static String ADMIN_LOGIN_USER_NAME = "adminUsername";

	/**
	 * 用户登录后保存用户所属的监控中心
	 */
	final static String LOGIN_EXPIRE_DATE = "expireDate";

	/**
	 * 验证码属性参数名
	 */
	final static String VALIDATE_IMG = "vimg";

	/**
	 * 用户拥有的菜单模块参数名
	 */
	final static String MENU_MODULES = "modules";

	/**
	 * 角色ID参数名
	 */
	final static String ROLE_ID = "rid";

	/**
	 * ID参数名
	 */
	final static String COMMON_ID = "id";

	/**
	 * 角色ID串参数名
	 */
	final static String ROLE_IDS = "rids";

	/**
	 * 角色名称参数名
	 */
	final static String ROLE_NAME = "roleName";

	/**
	 * 角色英文名称参数名
	 */
	final static String ROLE_NAME_EN = "roleNameEn";

	/**
	 * 必填参数名
	 */
	final static String REQUEST_STR0 = "Common.RequiredString0";

	/**
	 * 请选择
	 */
	final static String SELECT = "Common.Select";

	/**
	 * 密码参数名
	 */
	final static String PASSWORD = "password";

	/**
	 * 新密码参数名
	 */
	final static String PASSWORD_NEW = "newPassword";

	/**
	 * 新密码确认参数名
	 */
	final static String PASSWORD_NEW_CHECK = "newPasswordCheck";

	/**
	 * 确认密码错误参数名
	 */
	final static String PASSWORD_CHECK_ERROR = "passwordCheckError";

	/**
	 * 密码错误参数名
	 */
	final static String PASSWORD_ERROR = "passwordError";

	/**
	 * 失败消息参数名
	 */
	final static String ERROR_MSG = "errormsg";
	/**
	 * 结果消息
	 */
	final static String RESULT_MSG = "resultmsg";

	// /////////////////////////////// 录像统计
	// /////////////////////////////////////
	final static String BUSINESS_CONA = "cona";

	final static String START_INDEX = "startindex";

	final static String SESSION_NUM = "sessionnum";

	final static String TOTAL_NUM = "totalsessionnum";

	final static String SESSION = "session";

	final static String FUNCTION_CONTROL = "control";

	final static String GET = "get";

	// /////////////////////////////// 录像统计 END
	// /////////////////////////////////////

	final static String ERROR = "Common.Error";

	final static String NO_DELETE = "nodelete";

	final static String NOTDELETESERVER = "notdeleteserver";

	final static String FAIL = "Common.Fail";

	final static String UNKNOW_ERROR = "Common.UnkonwError";

	final static String NOT_FOUND = "notFound";

	final static String SUCCESS = "Common.Success";

	final static String OPERATE_ADD = "add";

	final static String OPERATE_UPDATE = "update";

	final static String OPERATE_DELETE = "delete";

	final static String OPERATE_SELETE = "selete";

	final static String PARAM_SUCCESS = "paramsuccess";

	final static String FORMAT = "format";

	final static String LENGTH = "length";

	final static String PARAM = "param";

	final static String EXIST = "Common.Exist";

	final static String USED = "used";

	final static String IP = "ip";

	final static String PORT = "port";

	final static String PATH = "path";

	final static String GROUP_NAME = "groupName";

	final static String STR_MIN_PASSWORD_LEN = "minPasswordLen";

	final static String STR_MAX_RANK_CODE = "maxRankCode";

	final static String SERVERSTATUS = "serverstatus";

	final static String NOTADD = "notadd";

	final static String NOTADDPARAM = "notaddparam";

	final static String ERRORACCOUNT = "error_account";

	final static String NOTEXIT = "notexit";

	final static String PRIVATEKEY = "private_key";

	final static String CONNECTION_FAIL = "connectionFail";

	// ////////////////////////////// 与NMS交互使用/////////////////////////////////
	final static String REQUEST = "Request";

	final static String REQUEST_INFO = "RequestInfo";

	final static String SERVICE = "Service";

	final static String DATE = "date";

	final static String DIGITAL_SEAL = "digitalseal";

	final static String BUSINESS = "business";

	final static String FUNCTION = "function";

	final static String MODULE = "Module";

	final static String ID = "id";

	final static String IP_ADDR = "ipaddr";

	final static String ACCOUNT = "account";

	final static String COMMAND_TYPE = "commandtype";

	final static String PARAM_LIST = "ParamList";

	final static String ACTION = "action";

	final static String COSP = "cosp";

	final static String COCA = "coca";

	final static String PARAMETER = "Parameter";

	final static String NAME = "name";

	final static String START = "start";

	final static String STOP = "stop";

	final static String ONLINE = "online";

	final static String OFFLINE = "offline";

	final static String ADD = "add";

	final static String DELETE = "delete";

	final static String ERROR_MESSAGE = "errormessage";

	final static String SECURITY = "Security";

	final static String SERVICE_NAME = "nms";

	final static String RESULT = "Result";

	final static String RESULT_DATA = "ResultData";

	final static String RESULT_CODE = "resultcode";

	final static String SERVER_PORT = "serverPort";

	final static String CPU_USAGE = "cpu_use";

	final static String MEM_FREE = "mem_free";

	final static String MEM_TOTAL = "mem_total";

	final static String DISK_TOTAL = "disk_total";

	final static String DISK_FREE = "disk_free";

	final static String MEMORY_USE = "mem_use";

	final static String DISK_USE = "disk_use";

	final static String SERVER_MODULE_LIST = "live_module";

	final static String UPDATE_TIME = "updateTime";

	final static String XML_ENCODING_TYPE = "UTF-8";

	final static String SYSTEM = "System";

	final static String RESULT_INFO = "ResultInfo";

	final static String PREFIX = "sip:";

	final static String NODELETEMODULE = "nodeletemodule";

	final static String APP = "app";

	final static String CONNECT_ERROR = "connect_error";

	// ////////////////////////////// END /////////////////////////////////

	// 必选选项
	final static String OPTION = "option";

	// property 文件路径
	static final String PROPERTIES_FILE_PATH = "/WEB-INF/config/bpim.properties";

	static final String PROBATION = "probation";

	static final String ADMINLOGININFO = "adminLoginInfo";

	static final String NEW_MESSAGE_COUNT = "newMessageCount";

	static final String USER_LOGIN_TIME = "userLoginTime";
}
