function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
function mOvr(src, clrOver) {
	if (!src.contains(event.fromElement)) {
		src.style.cursor = "default";
		src.bgColor = clrOver;
	}
}
function mOut(src, clrIn) {
	if (!src.contains(event.toElement)) {
		src.style.cursor = "default";
		src.bgColor = clrIn;
	}
}

// 分页跳转
function actionFun(pageNo, pageSize) {
    //alert(getLocation(pageNo));
	var pageForm = document.forms[0];
	if(pageForm != null) {
		pageForm.action = getLocation(pageNo, pageSize);
		pageForm.method = "POST";
		pageForm.submit();
	}
}

function movetoPage(pageNo, pageSize) {
	document.getElementById("pn").options[pageNo-1].selected = true;
	actionFun(pageNo, pageSize);
} 
// 分页跳转
function getLocation(pageNo, pageSize) {
	var pn = 0;//页面序号（从1开始）
	if (pageNo > 0) {
		pn = ""+pageNo;
	} else {
		pn = getEleValue("pn");
	}
	var action = getEleValue("action_page");
	var ps = 0;
	if (pageSize > 0) {
		ps = ""+pageSize;
	} else {
		ps = getEleValue("ps");
	}//页面大小    
	//var loc = "../" + action + "?pn=" + pn + "&ps=" + ps;
    var loc = "../" + action;
    //document.getElementById("pn").value=pn;
    //document.getElementById("ps").value=ps;
	return loc;
}

// 设置页面大小跳转
function changePageSize(ele) {
	var ps = ele.value;
	var pn = getEleValue("pn");
	//alert(ps + ":" + pn);
	actionFun(pn, ps);
}

// 跳转至页面
function gotoPage(ele) {
	var ps = getEleValue("ps");
	var pn = ele.value;
	//alert(ps + ":" + pn);
	actionFun(pn, ps);
}
function deleteData(id) {
	var action = getEleValue("action_del");
	var loc = "../" + action + "?ids=";
	if (id != null && id.length > 0) {
		if (!confirm("确定要删除所选的项？")) {
			return;
		}
		loc += id;
		document.location = loc;
		//alert(loc);
		//operate(loc);
		return;
	}
	var ids = "";
	var checkboxes = document.getElementsByName("chk");
	if (checkboxes != null) {
		for (var i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].checked) {
				ids += checkboxes[i].value + ",";
			}
		}
		if (ids.length == 0) {
			alert("请选择需要删除的项！");
			return;
		} else {
			if (!confirm("确定要删除所选的项？")) {
				return;
			}
		}
		loc += ids;
	} else {
		alert("无数据可删除！");
		return;
	}
	document.location = loc;
	//requestService(loc);
}
function addData() {
	var action = getEleValue("action_add");
	document.location = "../" + action;
}

// 全选删除
function checkall() {
	var checkedAll = document.getElementById("chkall").checked;
	var checkboxes = document.getElementsByName("chk");
	if (checkboxes != null) {
		for (var i = 0; i < checkboxes.length; i++) {
			checkboxes[i].checked = checkedAll;
		}
	}
}

// 选择删除
function checkboxChange() {
	var checkboxes = document.getElementsByName("chk");
	var chkCount = 0;
	if (checkboxes != null) {
		chkCount = checkboxes.length;
		var checkedCount = 0;
		for (var i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].checked) {
				checkedCount++;
			}
		}
		document.getElementById("chkall").checked = (chkCount == checkedCount);
	}
}

////////////////////////////////////////////////////////////////////////////////
/*
用于删除、用户停用、启用这样的操作，通过js直接访问某个URL
*/
var xmlrequest = null;
function createXMLHttpRequest() {
	
	if (window.XMLHttpRequest) {
	  		//mozilla 浏览器
		xmlrequest = new XMLHttpRequest();
	} else {
		if (window.ActiveXObject) {
	  			//IE浏览器
			try {
				xmlrequest = new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch (e) {
				try {
					xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");
				}
				catch (e) {
				}
			}
		}
	}
	
}
function requestService(url, callback) {
	if (xmlrequest == null) {
		createXMLHttpRequest();
	}
	//xmlrequest = new ActiveXObject("Msxml2.XMLHTTP");
	//打开与服务器响应地址的链接
	xmlrequest.open("GET", url, true);
	//设置请求头
	//xmlrequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	//设置处理响应的回调函数
	//xmlrequest.onreadystatechange = processResponse;
	xmlrequest.onreadystatechange = function() {
		if (xmlrequest.readyState == 4) {
	   		//判断响应是否成功
			if (xmlrequest.status == 200) {
	    		//信息已经成功返回,开始处理信息
				var text = xmlrequest.responseText;
				callback(text);
				//window.alert(text);
				//window.location.reload();
			    //在页面输出所有请求头
			    //document.getElementById("output").innerText = text;
			} else {
	    		//页面不正常
				window.alert("您所请求的页面异常");
			}
		}
	};
	//发送请求
	xmlrequest.send(null);
}

function operate(url) {
	requestService(url, function(text) {
		//var rst = result(text);
		//alert("operate:" + rst);
		var rst = text;
		if (isBlank(rst)) {
			alert(text);
		} else {
			if ("success" == rst) {
				var para = document.location.search;
				if (isBlank(para) || para.indexOf("pn") == -1) {
					document.location = "../" + document.getElementById("action_page").value;
				} else {
					window.location.reload();
				}
			} else {
				rst = rst.substring(rst.indexOf(":") + 1);
				alert(rst);
			}
		}
	});
}

function result(text) {
	if (isBlank(text)) {
		return "";
	}
	var index1 = text.indexOf("<span class=\"actionMessage\">") + 28;
	var index2 = text.indexOf("</span>");
	//alert(index1 + " + " + index2);
	var result = text.substring(index1, index2);
	return result;
}
////////////////////////////////////////////////////////////////////////////////


function setBgColor(tdElement, color) {
	tdElement.bgColor = color;
}

function chgChkBoxValue(propertyName, elmChkBox) {
	var code = parseInt(document.getElementById(propertyName).value);
	if (isNaN(code)) {
		code = 0;
	}
	if (elmChkBox.checked) {
		code += parseInt(elmChkBox.value);
	} else {
		code -= parseInt(elmChkBox.value);
	}
	document.getElementById(propertyName).value = code;
	//alert(document.getElementById(propertyName).value);
}

function setDefaultChecked(propertyName) {
	var code = parseInt(document.getElementById(propertyName).value);
	var chkboxes = document.getElementsByName(propertyName + "_chkbox");
	var value;
	for (var i = 0; i < chkboxes.length; i++) {
		var value = parseInt(chkboxes[i].value);
		if (value & code) {
			chkboxes[i].checked = true;
		} else {
			chkboxes[i].checked = false;
		}
	}
}

function isBlank(value) {
	return (value == null || value == "null" || value.trim().length < 1);
}

function getEleValue(element) {
	var eleObj = document.getElementById(element);
	if (eleObj != undefined) {
		return eleObj.value;
	} else {
		return null;
	}
}

String.prototype.trim = function () {
	return this.replace(/(^\s*)|(\s*$)/g, "");
};

function $(id){
	return document.getElementById(id);
}
