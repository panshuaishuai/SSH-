$(function() {
	$(window).resize(function() {
		var bodysHeight = $(window).height() - 80;
		$(".left_body").height(bodysHeight);
		$(".right_body").height(bodysHeight);
	});

	$(".save").on(
			"click",
			function() {
				if ($("input[name='password']").val() !== $(
						"input[name='againPassword']").val()) {
					alert("登录密码必须与重复密码相同！");
					return false;
				} else {
					return true;
				}
			});

	// 全选或反选
	$(".user_box")
			.on("click", function() {
						var checkboxItems = $("table").find(
								"input[name = 'checkbox']");
						var checkedboxItems = $("table").find(
								"input[name = 'checkbox']:checked");
						var isChecked = checkboxItems.length === checkedboxItems.length;
						checkboxItems.prop("checked", !isChecked);
					});

	// 所有复选框选中之后，全选复选框才能选中
	$("input[name='checkbox']").on("click", function() {
				var $checkbox = $("input[name='checkbox']");
				$(".user_box")
						.prop("checked", $checkbox.length === $checkbox.filter(":checked").length ? true : false);
			});

	$(".ul_select").on("click", function() {
		$(".right_body").load("list");
	}).first().click();

	$(".ul_add").on("click", function() {
		$(".right_body").load("add", function () {
			$("#form_id").submit(function(e) {
				e.preventDefault();
				var $this = $(this);
				$this.ajaxSubmit({
					success: function() {
						$(".right_body").load("list");
					}
				});
			});
			return_list();
		});
	});
	
	$(".ul_analyze").on("click", function() {
		$(".right_body").load("analyze");
	});
});

function return_list() {
	$(".return_list").on("click", function() {
		$(".right_body").load("list");
	});
};