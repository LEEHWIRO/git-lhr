
//공지사항 등록

function regist_go(){
   if($('input[name="writer"]').val() == ""){
      alert("작성자는 필수입니다.");
       return;
   }
   
   if($('input[name="title"]').val()==""){
      alert("제목은 필수입니다.");
      return;
   }
   
   if($('input[name="content"]').val()==""){
      alert("내용은 필수입니다.");
      return;
   }
   
   var form = $('form[role="form"]');
   form.submit();
}

















