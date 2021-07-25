<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/gallery.css">
<link rel="stylesheet" type="text/css" href="css/join_login.css">
<link rel="stylesheet" type="text/css" href="css/Diary.css">
<link rel="stylesheet" type="text/css" href="css/plan.css">
<link rel="stylesheet" type="text/css" href="css/list.css">
<link rel="stylesheet" type="text/css" href="css/etc.css">
<script type="text/javascript" src="js/login.js"></script> 
<script type="text/javascript" src="js/Gallery.js"></script>
<script type="text/javascript" src="js/reply.js"></script>
<script type="text/javascript" src="js/DiaryDel.js"></script>
<script type="text/javascript" src="js/todo.js"></script>
<script type="text/javascript" src="js/comment.js"></script>
<script type="text/javascript" src="js/info.js"></script>
<script type="text/javascript" src="js/join.js"></script>
<script type="text/javascript" src="js/dutchpay.js"></script>
<script type="text/javascript" src="js/plan.js"></script>
<script type="text/javascript" src="js/check.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>


</head>
<body>



<br>

   <table  id="ozTbl1" >
      
    <tr>
   
         <td rowspan="2"><a href="HC"> <img src="img/Ozorogo.png" width="100px" id = "logo"></a></td>
         <td colspan="4"></td>
         <td style="text-align: top; height: 40px" class="logjoin" width="250px">  
          <jsp:include page="${loginPage}"></jsp:include>
        </td>
      </tr>   
    
      
    
   
      
   <tr align="center">
         <td class="ozMenu" ><a href="PlannerController" >Planner</a></td>
         <td class="ozMenu"><a href="DiaryController">Diary</a></td>
         <td class="ozMenu"><a href="ListController">List</a></td>
         <td class="ozMenu"><a href="GalleryController">Gallery</a></td>
         <td class="ozMenu"><a href="ETCController">ETC</a></td>
      </tr>
      
      <tr  align="center">
         <td colspan="6">
            <table>
               <tr>
            
                  <td style="padding-top: 15px;" align="center"><jsp:include page="${contentPage}"></jsp:include></td>
               
               </tr>
            </table>
         </td>
      </tr>
   </table>

</body>
</html>