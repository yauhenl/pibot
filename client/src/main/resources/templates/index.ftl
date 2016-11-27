<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PiBot Control</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
        integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
        crossorigin="anonymous"></script>
<script type="text/javascript">
    $(document).keydown(function (e) {
        switch (e.which) {
            case 37: // left
                $.get("/action/MOVE_LEFT");
                break;

            case 38: // up
                $.get("/action/MOVE_FORWARD");
                break;

            case 39: // right
                $.get("/action/MOVE_RIGHT");
                break;

            case 40: // down
                $.get("/action/MOVE_BACKWARD");
                break;

            case 32: // down
                $.get("/action/MOVE_STOP");
                break;

            case 90: // down
                $.get("/action/ALL_MOTORS_POWER_ON");
                break;

            case 88: // down
                $.get("/action/ALL_MOTORS_POWER_OFF");
                break;

            default:
                return; // exit this handler for other keys
        }
        e.preventDefault(); // prevent the default action (scroll / move caret)
    });
</script>
</body>
</html>