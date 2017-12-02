<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Protótipo de ontologias</title>
        <style>
            body, 
            .menu,
            .sub-menu {
                margin: 0;
                padding: 0;
            }
            .clearfix:after{
                content: '.';
                display: block;
                clear: both;
                height: 0;
                line-height: 0;
                font-size: 0;
                visibility: hidden;
                overflow: hidden;
            }
            .menu,
            .sub-menu {
                list-style: none;
                background: #000;
            }
            .sub-menu {
                background: #444;
            }
            .menu a {
                text-decoration: none;
                display: block;
                padding: 10px;
                color: #fff;
                font-family: sans-serif;
                font-size: 14px;
                text-transform: uppercase;
                font-weight: 700;
            }
            .menu li {
                position: relative;
            }
            .menu > li {
                float: left;
            }
            .menu > li:hover {
                background: #444;

            }
            .menu li:hover > .sub-menu {
                display: inline-block;

            }

            .sub-menu {
                display: block;
                position: absolute;
                min-width: 150px;
            }

            .sub-menu li:hover {
                background: #555;

            }

            .sub-menu .sub-menu {
                display: none;
                top: 0;
                left: 100%;

            }

            [data-tooltip] {
                position: relative;
                font-weight: lighter;
                font-size: small;

            }

            [data-tooltip]:after {
                display: none;
                position: absolute; /*absolute*/
                top: -28px;
                left: 500px;
                padding: 5px;
                border-radius: 3px;
                left: calc(100% + 2px);
                content: attr(data-tooltip);
                white-space: nowrap;
                background-color: #0095ff;
                color: White;

            }

            [data-tooltip]:hover:after {
                display: block;
            }
        </style>
    </head>
    <body>
        <div class="menu-container">
            <ul class="menu clearfix">
                <li><a href="#">Classes</a>
                    <ul class="sub-menu clearfix">
                        <c:forEach var="k" items="${ClassesOnt}">${k}
                        </c:forEach>  
                    </ul>

                </li>
            </ul>
        </div>

    </body>
</html>
