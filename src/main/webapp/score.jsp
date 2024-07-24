<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Score</title>


     <style>
      h1{
                 text-align:center;
                margin:3rem 0px;
             }
            body {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                background-color: #f0f0f0;
                margin: 0;
                font-family: Arial, sans-serif;
            }

            .container {
                text-align: center;
            }

            .retry-button {
                background-color: #28a745;
                border: none;
                color: white;
                padding: 12px 20px;
                text-align: center;
                text-decoration: none;
                font-size: 16px;
                cursor: pointer;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }

            .retry-button:hover {
                background-color: #218838;
            }

            .retry-button:active {
                background-color: #1e7e34;
            }
        </style>

</head>
<body>

    <% int score = (int) session.getAttribute("score"); %>

     <div class="container">
     <h1>Score : <%=score%> </h1>
        <a class="retry-button" href ="startgame">Click here to retry.</a>
     </div>

</html>
