$(function(){
    var h1 = $(window).height();
    var h2 = $(".nav-myset").height();
    var h3 = $(window).width();
    $("#my-title").width((h3)*0.8+'px');
    $(".menu-myset").height((h1-h2-57) + 'px');
    $(".tab-myset").height((h1-h2-60) + 'px');
});
// 提交password的修改
$("body").on("click", ".submit_update_password",function(e){
    if($('#oldpassword').val().trim()==''){
        toastr.warning('原密码不能为空');
    }
    else if($('#newpassword').val().trim()==''){
        toastr.warning('新密码不能为空');
    }
    else if($('#newpassword').val().trim()!=$('#repassword').val().trim()){
        toastr.warning('两次填写密码不一致');
    }
    // else if($('#prepassword').val().trim()!="${admin.admin_Password}"){
    //     toastr.error('原密码填写错误');
    // }
    else{
        $.ajax({
           type:"POST",
            url:"/admin/updatePassword",
            async: false,
            data: $("#admin_update").serialize(),
            success:function (data) {
                var tmp = data;
                if(tmp == 0){
                    toastr.error("原密码错误");
                }else{
                    $(location).attr('href',"/admin/home");
                    // toastr.success("修改密码成功");
                }
            }
        });
    }
});