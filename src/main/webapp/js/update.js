$(function() {
	$(".compile").on("click", function() {
		var userId = $(this).data("id");
		$(".right_body").load("update", {
			userId : userId
		}, function() {
			$("#form_update").submit(function(e) {
				e.preventDefault();
				var $this = $(this);
				$this.ajaxSubmit({
					success : function() {
						$(".right_body").load("list");
					}
				});
			});
			return_list();
		});
	});

	$(".delete").on("click", function() {
		if (confirm("是否确定删除？")) {
			var userId = $(this).data("id");
			$.ajax({
				url : "delete",
				type : "post",
				data : {
					userId : userId
				},
				success : function() {
					$(".right_body").load("list");
				}
			});
		}
	});
	
	/*$("#like_form").on("submit", function(e) {
		e.preventDefault();
		var $this = $(this);
		$this.aja xSubmit({
			success: function(data) {
				$(".right_body").load("list",{data :data});
			}
			});
		});
	
	var $container = $("#container");
	var $ul_2 = $container.find(".ul_2");
	var $form = $("form[name='pagingForm']");

	$form.on("submit", function(e) {
		// 阻止表单默认提交事件
		e.preventDefault();
		var $this = $(this);
		$this.ajaxSubmit({
			success : function(data) {
				$(".right_body").load("list", {data :data});
			}
		});
	});*/
});