$( document ).ready(function() {
            $( "#createCall" ).click(function() {
                var e = document.getElementById("fromNumber");
                var toNumber = document.getElementById("toNumber").value;
                var fromNumber = e.options[e.selectedIndex].text;

                var requestString = { "toNumber" : toNumber, "fromNumber": fromNumber};
                $.ajax({
                  url: "/call",
                  type: "POST",
                  data: requestString,
                  success: function(data){
                      //$("#callid").val(data);
                      $("#form-call").submit();
                  }
                });
            });
        });