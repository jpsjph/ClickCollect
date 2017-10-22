$(document).ready(function(){

        $('#btn1').click(function(){
            $('#tr1').find(".numeric").each(function(){
                $(this).val(12)
             });

            var data= { "eventId":"001",
             "name":"Lucky Dip",
             "action":"LuckDip",
             "numbers":"12,12,12,12,12",
             "browser":"chrome"};

              $.ajax({
                     url: 'http://localhost:8080/eventClicks',
                             type: 'POST',
                             contentType: "application/json; charset=utf-8",
                             dataType: 'json',
                             data:JSON.stringify(data),
                             success: function (data, textStatus, xhr) {
                                      console.log(data);
                                  },
                                  error: function (xhr, textStatus, errorThrown) {
                                      console.log('Error in Operation');
                                  }
                              });

          });



          $('#btn2').click(function(){
            $('#tr2').find(".numeric").each(function(){
                $(this).val(5)
             });
          });

          $('#btn3').click(function(){
            $('#tr3').find(".numeric").each(function(){
                $(this).val(16)
             });
          });

           $('#btn4').click(function(){
            $('#tr4').find(".numeric").each(function(){
                $(this).val(4)
             });
          });

            $('#btn5').click(function(){
            $('#tr5').find(".numeric").each(function(){
                $(this).val(4)
             });
          });
})