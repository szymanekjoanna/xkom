/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-12-14 07:28:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homePage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"text-center\" >\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\" style=\"margin-top: 100px\">\r\n");
      out.write("\t<div class=\"row justify-content-center\" style=\"margin-bottom: 50px\">\r\n");
      out.write("                        <div class=\"col-12 col-md-10 col-lg-8\">\r\n");
      out.write("                        \t<p>Wyszukaj produkty na stronie x-kom.pl:</p>\r\n");
      out.write("                            <form class=\"card card-sm\">\r\n");
      out.write("                                <div class=\"card-body row no-gutters align-items-center\">\r\n");
      out.write("                                    <div class=\"col-auto\">\r\n");
      out.write("                                        <i class=\"fas fa-search h4 text-body\"></i>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <!--end of col-->\r\n");
      out.write("                                    <div class=\"col\">\r\n");
      out.write("                                        <input class=\"form-control form-control-lg form-control-borderless\" type=\"search\" id=\"itemToSearch\" name=\"itemToSearch\" placeholder=\"Nazwa produktu\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <!--end of col-->\r\n");
      out.write("                                    <div class=\"col-auto\" style=\"margin-left: 20px\">\r\n");
      out.write("                                        <button class=\"btn btn-lg btn-primary\" type=\"submit\" id=\"triggerETL\" name=\"triggerETL\">ETL</button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <!--end of col-->\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!--end of col-->\r\n");
      out.write("                    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<form>\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-4\"></div>\r\n");
      out.write("            <div class=\"col-md-4\">\r\n");
      out.write("                    <p>Wykonaj osobne akcje:</p>\r\n");
      out.write("                    <button type=\"button\" style=\"margin-bottom: 50px\"class=\"btn btn-warning\" id=\"triggerExtract\" name=\"triggerExtract\">Extract</button>\r\n");
      out.write("                    <button type=\"button\" style=\"margin-left: 10px; margin-bottom: 50px\" class=\"btn btn-info\" id=\"triggerTransform\" name=\"triggerTransform\">Transform</button>\r\n");
      out.write("                    <button type=\"button\" style=\"margin-left: 10px; margin-bottom: 50px\" class=\"btn btn-success\" id=\"triggerLoad\" name=\"triggerLoad\">Load</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        <div class=\"col-md-4\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    $(function(){\r\n");
      out.write("        $('#triggerETL').on('click', function(event) {\r\n");
      out.write("            event.preventDefault();\r\n");
      out.write("            event.stopPropagation();\r\n");
      out.write("            console.log(\"Hello from front\");\r\n");
      out.write("            var itemToSearch = $('input[name=itemToSearch]').val();\r\n");
      out.write("            console.log(itemToSearch);\r\n");
      out.write("\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url: \"/etl\",\r\n");
      out.write("                type: \"post\",\r\n");
      out.write("                data: {itemToSearch}\r\n");
      out.write("            }).done(function(data){\r\n");
      out.write("                console.log(data)\r\n");
      out.write("                $.notify({\r\n");
      out.write("                    message: data\r\n");
      out.write("                },{\r\n");
      out.write("                    placement: {\r\n");
      out.write("                        from: 'bottom',\r\n");
      out.write("                        align: 'right'\r\n");
      out.write("                    },\r\n");
      out.write("                    type: 'success'\r\n");
      out.write("                });\r\n");
      out.write("            }).fail(function(data){\r\n");
      out.write("                console.log(xhr);\r\n");
      out.write("                console.log(status);\r\n");
      out.write("                console.log(\"________________________\");\r\n");
      out.write("                console.log(error);\r\n");
      out.write("                $.notify({\r\n");
      out.write("                    message: data\r\n");
      out.write("                },{\r\n");
      out.write("                    placement: {\r\n");
      out.write("                        from: 'bottom',\r\n");
      out.write("                        align: 'right'\r\n");
      out.write("                    },\r\n");
      out.write("                    type: 'danger'\r\n");
      out.write("                })\r\n");
      out.write("            })\r\n");
      out.write("        })\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    $(function(){\r\n");
      out.write("        $('#triggerExtract').on('click', function(event) {\r\n");
      out.write("            event.preventDefault();\r\n");
      out.write("            event.stopPropagation();\r\n");
      out.write("            console.log(\"Hello from front\");\r\n");
      out.write("            var itemToSearch = $('input[name=itemToSearch]').val();\r\n");
      out.write("            console.log(itemToSearch);\r\n");
      out.write("\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url: \"/extract\",\r\n");
      out.write("                type: \"post\",\r\n");
      out.write("                data: {itemToSearch}\r\n");
      out.write("            }).done(function(data){\r\n");
      out.write("                console.log(data)\r\n");
      out.write("                $.notify({\r\n");
      out.write("                    message: data\r\n");
      out.write("                },{\r\n");
      out.write("                    placement: {\r\n");
      out.write("                        from: 'bottom',\r\n");
      out.write("                        align: 'right'\r\n");
      out.write("                    },\r\n");
      out.write("                    type: 'success'\r\n");
      out.write("                });\r\n");
      out.write("            }).fail(function(data){\r\n");
      out.write("                $.notify({\r\n");
      out.write("                    message: data\r\n");
      out.write("                },{\r\n");
      out.write("                    placement: {\r\n");
      out.write("                        from: 'bottom',\r\n");
      out.write("                        align: 'right'\r\n");
      out.write("                    },\r\n");
      out.write("                    type: 'danger'\r\n");
      out.write("                })\r\n");
      out.write("            })\r\n");
      out.write("        })\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    $(function(){\r\n");
      out.write("        $('#triggerTransform').on('click', function(event) {\r\n");
      out.write("            event.preventDefault();\r\n");
      out.write("            event.stopPropagation();\r\n");
      out.write("            console.log(\"Hello from front\");\r\n");
      out.write("            //var itemToSearch = $('input[name=itemToSearch]').val();\r\n");
      out.write("            //console.log(itemToSearch);\r\n");
      out.write("\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url: \"/transform\",\r\n");
      out.write("                type: \"post\",\r\n");
      out.write("                //data: {itemToSearch}\r\n");
      out.write("            }).done(function(data){\r\n");
      out.write("                console.log(data)\r\n");
      out.write("                $.notify({\r\n");
      out.write("                    message: data\r\n");
      out.write("                },{\r\n");
      out.write("                    placement: {\r\n");
      out.write("                        from: 'bottom',\r\n");
      out.write("                        align: 'right'\r\n");
      out.write("                    },\r\n");
      out.write("                    type: 'success'\r\n");
      out.write("                });\r\n");
      out.write("            }).fail(function(data){\r\n");
      out.write("                console.log(xhr);\r\n");
      out.write("                console.log(status);\r\n");
      out.write("                console.log(\"________________________\");\r\n");
      out.write("                console.log(error);\r\n");
      out.write("                $.notify({\r\n");
      out.write("                    message: data\r\n");
      out.write("                },{\r\n");
      out.write("                    placement: {\r\n");
      out.write("                        from: 'bottom',\r\n");
      out.write("                        align: 'right'\r\n");
      out.write("                    },\r\n");
      out.write("                    type: 'danger'\r\n");
      out.write("                })\r\n");
      out.write("            })\r\n");
      out.write("        })\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    $(function(){\r\n");
      out.write("        $('#triggerLoad').on('click', function(event) {\r\n");
      out.write("            event.preventDefault();\r\n");
      out.write("            event.stopPropagation();\r\n");
      out.write("            console.log(\"Hello from front\");\r\n");
      out.write("            //var itemToSearch = $('input[name=itemToSearch]').val();\r\n");
      out.write("            //console.log(itemToSearch);\r\n");
      out.write("\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url: \"/load\",\r\n");
      out.write("                type: \"post\",\r\n");
      out.write("                //data: {itemToSearch}\r\n");
      out.write("            }).done(function(data){\r\n");
      out.write("                console.log(data)\r\n");
      out.write("                $.notify({\r\n");
      out.write("                    message: data\r\n");
      out.write("                },{\r\n");
      out.write("                    placement: {\r\n");
      out.write("                        from: 'bottom',\r\n");
      out.write("                        align: 'right'\r\n");
      out.write("                    },\r\n");
      out.write("                    type: 'success'\r\n");
      out.write("                });\r\n");
      out.write("            }).fail(function(data){\r\n");
      out.write("                console.log(xhr);\r\n");
      out.write("                console.log(status);\r\n");
      out.write("                console.log(\"________________________\");\r\n");
      out.write("                console.log(error);\r\n");
      out.write("                $.notify({\r\n");
      out.write("                    message: data\r\n");
      out.write("                },{\r\n");
      out.write("                    placement: {\r\n");
      out.write("                        from: 'bottom',\r\n");
      out.write("                        align: 'right'\r\n");
      out.write("                    },\r\n");
      out.write("                    type: 'danger'\r\n");
      out.write("                })\r\n");
      out.write("            })\r\n");
      out.write("        })\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"/static/bootstrap-notify.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
