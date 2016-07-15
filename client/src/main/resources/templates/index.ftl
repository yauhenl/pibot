<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PiBot Control</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

  </head>
  <body>  	 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <script type="text/javascript">
  		$(document).keydown(function(e) {
  		    alert(e.which);
		    switch(e.which) {
		        case 37: // left
		        $.get("http://192.168.1.7/move/left");
		        break;

		        case 38: // up
		        $.get("http://192.168.1.7/move/forward");
		        break;

		        case 39: // right
		        $.get("http://192.168.1.7/move/right");
		        break;

		        case 40: // down
		        $.get("http://192.168.1.7/move/backward");
		        break;

		        case 90: // down
		        $.get("http://192.168.1.7/switch/on");
		        break;

		        case 88: // down
		        $.get("http://192.168.1.7/switch/off");
		        break;

		        default: return; // exit this handler for other keys
		    }
		    e.preventDefault(); // prevent the default action (scroll / move caret)
		});
		$(document).keyup(function(e) {
                switch(e.which) {
                    case 37: // left
                    $.get("http://192.168.1.7/move/stop");
                    break;

                    case 38: // up
                    $.get("http://192.168.1.7/move/stop");
                    break;

                    case 39: // right
                    $.get("http://192.168.1.7/move/stop");
                    break;

                    case 40: // down
                    $.get("http://192.168.1.7/move/stop");
                    break;

                    default: return; // exit this handler for other keys
                }
                e.preventDefault(); // prevent the default action (scroll / move caret)
            });
  	</script> 
  </body>
</html>