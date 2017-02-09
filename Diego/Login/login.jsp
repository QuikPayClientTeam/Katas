<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.security.*,java.util.*,com.infinet.util.encode.*" %>

<%
    StringBuffer sb = new StringBuffer();
    String timestamp = String.valueOf(System.currentTimeMillis());
    String link = null;
    HashMap parameters = new HashMap();

    String userId = request.getParameter("userId");
    String fullName = request.getParameter("fullName");
    String email = request.getParameter("email");
    String paymentMethod = request.getParameter("paymentMethod");
    String amountDue = request.getParameter("amountDue");
    String key = request.getParameter("key");
    String submit = request.getParameter("submit");
    String domain = "";
    boolean redirect = false;

    if ("student_tuition".equals(submit))
    {
        domain = "student_tuition";
        sb.append(userId);
        sb.append(fullName);
        sb.append(email);
        sb.append(paymentMethod);
        sb.append(amountDue);
        sb.append(timestamp);
        sb.append(key);
        parameters.put("userId",userId);
        parameters.put("fullName",fullName);
        parameters.put("email",email);
        parameters.put("paymentMethod",paymentMethod);
        parameters.put("amountDue",amountDue);
        parameters.put("timestamp", timestamp);
        redirect = true;
    }
    else if ("application_fee".equals(submit))
    {
        domain = "application_fee";
        String redirectUrl = request.getParameter("redirectUrl");
        String redirectUrlParameters = request.getParameter("redirectUrlParameters");
        String retriesAllowed = request.getParameter("retriesAllowed");
        String userChoice1 = request.getParameter("userChoice1");
        String userChoice2 = request.getParameter("userChoice2");
        String userChoice3 = request.getParameter("userChoice3");
        sb.append(userId);
        sb.append(fullName);
        sb.append(email);
        sb.append(paymentMethod);
        sb.append(amountDue);
        sb.append(redirectUrl);
        sb.append(redirectUrlParameters);
        sb.append(retriesAllowed);
        sb.append(userChoice1);
        sb.append(userChoice2);
        sb.append(userChoice3);
        sb.append(timestamp);
        sb.append(key);
        parameters.put("userId",userId);
        parameters.put("fullName",fullName);
        parameters.put("email",email);
        parameters.put("paymentMethod",paymentMethod);
        parameters.put("amountDue",amountDue);
        parameters.put("redirectUrl",redirectUrl);
        parameters.put("redirectUrlParameters",redirectUrlParameters);
        parameters.put("retriesAllowed",retriesAllowed);
        parameters.put("userChoice1", userChoice1);
        parameters.put("userChoice2", userChoice2);
        parameters.put("userChoice3", userChoice3);
        parameters.put("timestamp", timestamp);
        redirect = true;
    }
    link = "/" + domain + "/payer.do";

    MessageDigest md = MessageDigest.getInstance("MD5");
    byte[] digest = md.digest(sb.toString().getBytes());
    Encoder encoder = Encoder.getEncoder("HEX");
    String hash = encoder.encode(digest);
    parameters.put("hash", hash);

    request.setAttribute("my_param", parameters);
    
    link = request.getContextPath() + link + "?";
    for (Object paramKey : parameters.keySet())
    {
      link = link + (String)paramKey + "=" + (String)parameters.get(paramKey) + "&";
    }
    link = link.substring(0, link.length() - 1);
    if (redirect)
    {
        response.sendRedirect(link);
    }
%>

<html>
  <head>
    <title>FSCJ Test Login Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  </head>

  <body>
    <div class="panel-info text-center">
      <h1>FSCJ Test Login Page</h1>
    </div>
    <div id="accordian" class="panel-group container">
      <div class="panel panel-info">
        <div class="panel-heading text-center">
          <h2><a data-toggle="collapse" data-parent="#accordian" href="#student-tuition-panel">Student Tuition Payer</a></h2>
        </div>
        <div id="student-tuition-panel" class="panel-collapse collapse">
          <form name="student_tuition" class="form-horizontal" method="get" action="login.jsp">
            <div class="panel-body">
              <div class="form-group">
                <label class="control-label col-sm-offset-2 col-sm-2" >User ID:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control" name="userId" value="123456789"/>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-offset-2 col-sm-2" >Name:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control" name="fullName" value="John Doe"/>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-offset-2 col-sm-2" >Email:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control" name="email" value="qp_test@nelnet.net"/>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-offset-2 col-sm-2" >Payment Method:</label>
                <div class="col-sm-6">
                  <select class="form-control" name="paymentMethod"/>
                    <option>ach_cc</option>
                    <option>ach</option>
                    <option>cc</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-offset-2 col-sm-2" >Amount:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control" name="amountDue" value="100"/>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-offset-2 col-sm-2" >Key:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control" name="key" value="key"/>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-4 col-sm-6">  
                  <button type="submit" name="submit" class="btn btn-primary" value="student_tuition">Login</button>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>

      <div class="panel panel-info">
        <div class="panel-heading text-center">
          <h2><a data-toggle="collapse" data-parent="#accordian" href="#application-fee-panel">Application Fee Payer</a></h2>
        </div>
        <div id="application-fee-panel" class="panel-collapse collapse">
          <div class="panel-body">
            <form name="application_fee" method="get" action="login.jsp" class="form-horizontal">
              <div class="form-group">
                <label class="control-label col-sm-offset-2 col-sm-2" >User ID:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control" name="userId" value="123456789"/>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-offset-2 col-sm-2" >Name:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control" name="fullName" value="John Doe"/>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-offset-2 col-sm-2" >Email:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control" name="email" value="qp_test@nelnet.net"/>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-offset-2 col-sm-2" >Payment Method:</label>
                <div class="col-sm-6 dropdown">
                  <select class="form-control" name="paymentMethod"/>
                    <option>ach_cc</option>
                    <option>ach</option>
                    <option>cc</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-offset-2 col-sm-2" >Amount:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control" name="amountDue" value="100"/>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-offset-2 col-sm-2" >Redirect URL:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control" name="redirectUrl" value="https://localhost:8101/quikpay2/test/receipt.jsp"/>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-offset-2 col-sm-2" >Redirect URL Parameters:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control" name="redirectUrlParameters" value="transactionId,userChoice1,userChoice2,userChoice3"/>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-offset-2 col-sm-2" >Retries Allowed:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control" name="retriesAllowed" value="2"/>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-offset-2 col-sm-2" >User Choice 1:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control" name="userChoice1" value="test1"/>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-offset-2 col-sm-2" >User Choice 2:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control" name="userChoice2" value="test2"/>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-offset-2 col-sm-2" >User Choice 3:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control" name="userChoice3" value="test3"/>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-offset-2 col-sm-2" >Key:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control" name="key" value="key"/>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-4 col-sm-6">  
                  <button type="submit" name="submit" class="btn btn-primary" value="application_fee">Login</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>