<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="assets/ico/favicon.ico">

        <title>INSTANT - Bootstrap Theme</title>

        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/font-awesome.min.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy this line! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>

        <!-- Static navbar -->
        <div class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">HOME</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="formOntologia.jsp">Home</a></li>
                        <li><a href="about.jsp">About</a></li>
                        <li><a href="#works">Works</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>


        <div id="headerwrap">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-lg-offset-3">
                        <h4>GECID CES-JF 2017</h4>
                        <h1>Hierarquia Ontológica</h1>

                    </div>
                </div><! --/row -->
            </div> <!-- /container -->
        </div><! --/headerwrap -->

        <section id="works"></section>
        <div class="container">
            <div class="row centered mt mb">
                <center>
                    <h1>Visualizador de Hieraquia Ontológica</h1>
                    <br><br><br>

                    <form action="listarOntologias" enctype="multipart/form-data" method="post">
                        <div class="form-group row">
                            <label for="example-text-input" class="col-xs-2 col-form-label">Insira o arquivo de Ontologia:</label>
                            <div class="col-xs-10">
                                <input  type="file" name="arquivo">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-url-input" class="col-xs-2 col-form-label">Insira a URI:</label>
                            <div class="col-xs-10">
                                <input class="form-control" type="text" name="Enviar">
                            </div>
                        </div>

                        <div class="form-group row">
                         
                            (Só será necessário caso dê problemas na Hora de exibição, pelo fato que existem tipos de arquivos de ontologia escrito de formas diferentes.)
                       <input type="submit" value="Visualizar Hierarquia e Anotar Sematicamente">
                
                           
                        </div>
                      

                    </form>
            </div><! --/row -->
        </div><! --/container -->

        <div id="social">
            <div class="container">
                <div class="row centered">
                    <div class="col-lg-2">
                        <a href="#"><i class="fa fa-dribbble"></i></a>
                    </div>
                    <div class="col-lg-2">
                        <a href="#"><i class="fa fa-facebook"></i></a>
                    </div>
                    <div class="col-lg-2">
                        <a href="#"><i class="fa fa-twitter"></i></a>
                    </div>
                    <div class="col-lg-2">
                        <a href="#"><i class="fa fa-linkedin"></i></a>
                    </div>
                    <div class="col-lg-2">
                        <a href="#"><i class="fa fa-instagram"></i></a>
                    </div>
                    <div class="col-lg-2">
                        <a href="#"><i class="fa fa-tumblr"></i></a>
                    </div>

                </div><! --/row -->
            </div><! --/container -->
        </div><! --/social -->

        <div id="footerwrap">
            <div class="container">
                <div class="row centered">
                    <div class="col-lg-4">
                        <p><b>GCID, CENTRO DE ENSINO SUPERIOR DE JUIZ DE FORA</b></p>
                    </div>

                    <div class="col-lg-4">
                        <p>Living in the amazing London.</p>
                    </div>
                    <div class="col-lg-4">
                        <p>hello@instant.com</p>
                    </div>
                </div>
            </div>
        </div><! --/footerwrap -->



        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>


    </body>
</html>
