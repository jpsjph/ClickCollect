$(document).ready(function(){

        $('#btn1').click(function(){
        var arr1=[]
            $('#tr1').find(".numeric").each(function(){
                 var num=randomNumber(-59,50);
                     $(this).val(num);
                     arr1.push(num)
             });

            var eventData= { "eventId":"001",
             "name":"Lucky Dip",
             "action":"LuckDip",
             "numbers":arr1.join(","),
             "browser":"chrome"};
             sendData(eventData)
           });

             $('#clear1').click(function(){
                  $('#tr1').find(".numeric").each(function(){
                           $(this).val('')
                 });
              });


          $('#btn2').click(function(){
           var arr2=[]
            $('#tr2').find(".numeric").each(function(){
                var num=randomNumber(-59,50);
                $(this).val(num);
                arr2.push(num)
             });
               var eventData= { "eventId":"002",
                          "name":"Lucky Dip",
                          "action":"LuckDip",
                          "numbers":arr2.join(","),
                          "browser":"chrome"};
                          sendData(eventData)
                        });

           $('#clear2').click(function(){
                $('#tr2').find(".numeric").each(function(){
                             $(this).val('')
                });
             });

          $('#btn3').click(function(){
           var arr3=[]
            $('#tr3').find(".numeric").each(function(){
                  var num=randomNumber(-59,50);
                   $(this).val(num);
                   arr3.push(num)
             });
               var eventData= { "eventId":"003",
                          "name":"Lucky Dip",
                          "action":"LuckDip",
                          "numbers":arr3.join(","),
                          "browser":"chrome"};
                          sendData(eventData)
                  });


               $('#clear3').click(function(){
                $('#tr3').find(".numeric").each(function(){
                             $(this).val('')
                });
              });


           $('#btn4').click(function(){
           var arr4=[]
            $('#tr4').find(".numeric").each(function(){
                 var num=randomNumber(-59,50);
                      $(this).val(num);
                    arr4.push(num)
             });
               var eventData= { "eventId":"004",
                          "name":"Lucky Dip",
                          "action":"LuckDip",
                          "numbers":arr4.join(","),
                          "browser":"chrome"};
                          sendData(eventData)
                });

            $('#btn5').click(function(){
            var arr5=[]
            $('#tr5').find(".numeric").each(function(){
                  var num=randomNumber(-59,50);
                   $(this).val(num);
                  arr5.push(num)
             });
               var eventData= { "eventId":"005",
                          "name":"Lucky Dip",
                          "action":"LuckDip",
                          "numbers":arr5.join(","),
                          "browser":"chrome"};
                          sendData(eventData)
                });


          $('#clear4').click(function(){
                $('#tr4').find(".numeric").each(function(){
                     $(this).val('')
                });
              });

          $('#clear5').click(function(){
              $('#tr5').find(".numeric").each(function(){
                   $(this).val('')
                          });
                     });

          var sendData = function(data){

               $.ajax({
                          url: 'http://localhost:8080/eventClicks',
                          type: 'POST',
                          contentType: "application/json; charset=utf-8",
                          dataType: 'json',
                          crossDomain: false,
                          data:JSON.stringify(data),
                          success: function (data, textStatus, xhr) {
                                   console.log(data);
                               },
                               error: function (xhr, textStatus, errorThrown) {
                                   console.log('Error in Operation');
                               }
                           });
                       }

             var randomNumber=function(min,max){
                return Math.abs(Math.floor(Math.random()*(max-min+1)+min));
             }



})