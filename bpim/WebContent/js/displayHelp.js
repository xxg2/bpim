var searchQuotaHelp = "设定所要查询定额的条件,点击查询按钮,显示该条定额相关内容.点击查看按钮,系统显示该条定额的详细说明及工料机组成.如选择不设定查询条件,直接点击查询按钮,则显示系统全部定额数据信息.";
var searchGovernmentInventory2003Help = "包含《冶金工业建设工程工程量清单计价规则(2007版)》和《人防工程工程量清单计价规范》（RFJ03-2009）的相关数据信息.设定所要查询工程量清单的条件,点击查询按钮,显示该条清单相关内容.如选择不设定查询条件,直接点击查询按钮,则显示系统全部工程量清单数据信息.";
var searchGovernmentInventory2008Help = "设定所要查询工程量清单的条件,点击查询按钮,显示该条清单相关内容.如选择不设定查询条件,直接点击查询按钮,则显示系统全部工程量清单数据信息.";
var searchGovernmentFileHelp = "设定所要查询文件的条件,点击查询按钮,显示该文件概要.点击查看按钮,系统显示该条文件的详细内容.如选择不设定查询条件,直接点击查询按钮,则显示系统全部文件信息.";
var searchGuideDataHelp = "设定所要查询工料机的条件,点击查询按钮,显示该条工料机的相关价格内容.如选择不设定查询条件,直接点击查询按钮,则显示系统全部工料机数据信息."; 


var searchQuotaMenuHelp ="各地及行业部门发布的定额数据查询";
var searchGovernmentInventory_2003_menu_Help ="《建设工程工程量清单计价规范》(GB50500-2003)及人防和冶金工程量清单数据查询";


function displayHelp(id,text){
	$(id).innerHTML = text;
	$(id).style.display = "block";
}

function unDisplayHelp(id){
	$(id).style.display = "none";
}

function displayMenuHelp(menuId,helpId,text,width){
	$(menuId).style.width = width;
	$(helpId).innerHTML = text;
	$(helpId+"Li").style.display = "block";
}

function unDisplayMenuHelp(menuId,helpId){
	$(menuId).style.width = "110px";
	$(helpId+"Li").style.display = "none";
}
