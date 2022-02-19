
// function emailAuthorSend() {
//         let userEmail=$("#userEmail").val();
//         let messageDTO={
//             userEmail:userEmail ,
//         };
//             $.ajax({
//                 url: "/user/EmailAuthor",
//                 data: messageDTO,
//                 type:"GET",
//             }).success(function (message) {
//                 const key = $.trim(message.key);
//             if(key == 'succese') {
//                 console.log(message.msg)
//                 $("#emailSendText").replaceAll(message.msg);
//             }
//             if(key == 'emailDuplicate') {
//                 console.log(message.msg)
//                 $("#emailSendText").text(message.msg);
//             }
//             else {
//                 console.log(message.msg)
//                 $("#emailSendText").text(message.msg);
//             }
//
//         });
//     }

