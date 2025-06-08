<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
var menus = [{
	"backMenu": [{
		"child": [{
			"buttons": ["修改", "删除"],
			"menu": "客户信息",
			"menuJump": "列表",
			"tableName": "kehu"
		}],
		"menu": "客户管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除", "运输中", "已收货"],
			"menu": "物流信息",
			"menuJump": "列表",
			"tableName": "wuliu"
		}],
		"menu": "物流管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除", "运输中"],
			"menu": "快递信息",
			"menuJump": "列表",
			"tableName": "kuaidi"
		}],
		"menu": "快递管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "物流详情信息",
			"menuJump": "列表",
			"tableName": "wuliuxiangqing"
		}],
		"menu": "物流详情管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "快递详情信息",
			"menuJump": "列表",
			"tableName": "kuaidixiangqing"
		}],
		"menu": "快递详情管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "物流公司信息",
			"menuJump": "列表",
			"tableName": "wuliugongshi"
		}],
		"menu": "物流公司管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "快递公司信息",
			"menuJump": "列表",
			"tableName": "kuaidigongshi"
		}],
		"menu": "快递公司管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "留言信息",
			"menuJump": "列表",
			"tableName": "liuyanxinxi"
		}],
		"menu": "留言管理"
	}, {
			"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "公告信息",
			"menuJump": "列表",
			"tableName": "xitonggonggao"
		}],
		"menu": "公告管理"
	}],
	"frontMenu": [],
	"roleName": "管理员",
	"tableName": "users"
}, {
	"backMenu": [{
		"child": [{
			"buttons": ["修改"],
			"menu": "客户信息",
			"menuJump": "列表",
			"tableName": "kehu"
		}],
		"menu": "客户管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "物流信息",
			"menuJump": "列表",
			"tableName": "wuliu"
		}],
		"menu": "物流管理"
	}, {
		"child": [{
			"buttons": ["新增", "已收货"],
			"menu": "快递信息",
			"menuJump": "列表",
			"tableName": "kuaidi"
		}],
		"menu": "快递管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "物流详情信息",
			"menuJump": "列表",
			"tableName": "wuliuxiangqing"
		}],
		"menu": "物流详情管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "快递详情信息",
			"menuJump": "列表",
			"tableName": "kuaidixiangqing"
		}],
		"menu": "快递详情管理"
	}, {
		"child": [{
			"buttons": ["新增"],
			"menu": "留言信息",
			"menuJump": "列表",
			"tableName": "liuyanxinxi"
		}],
		"menu": "留言管理"
	}, {
			"child": [{
			"buttons": [],
			"menu": "公告信息",
			"menuJump": "列表",
			"tableName": "xitonggonggao"
		}],
		"menu": "公告管理"
	}],
	"frontMenu": [],
	"roleName": "客户",
	"tableName": "kehu"
}];
var hasMessage = '';
