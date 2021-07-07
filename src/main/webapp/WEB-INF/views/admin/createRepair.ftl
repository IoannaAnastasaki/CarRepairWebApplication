<#import "/spring.ftl" as spring/>

<head>
    <meta charset="UTF-8">
    <title>CrateRepair Form</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="/style.css">
</head>

<body>
    <#include "/navbar.ftl">
    <h1>Add a new Repair</h1>
    <h2>${message!""}</h2>
    <h2>${errorMessage!""}</h2>
	<div class="container">
        <form class="form-horizontal" role="form" action="/admin/createRepair" method="POST" id="newRepairForm" name="newRepairForm">

			<div class="form-group">
				<@spring.bind "newRepairForm.taxNumber"/>
                <label for="name" class="col-sm-3 control-label">Owner tax number</label>
                <div class="col-sm-9">
                    <input type="text" name="taxNumber" id="taxNumber" placeholder="123456789" class="form-control">
                </div>

            </div>
          <div class="form-group">
				<@spring.bind "newRepairForm.plateNumber"/>
                <label for="name" class="col-sm-3 control-label">Vehicle plate number</label>
                <div class="col-sm-9">
                    <input type="text" name="plateNumber" id="plateNumber" placeholder="XXX-1000" class="form-control">
                </div>

            </div>
			<div class="form-group">
				<@spring.bind "newRepairForm.description"/>
                <label class="col-sm-3 control-label">Repair description</label>
			    <div class="col-sm-9">
			        <textarea class="form-control" rows="5" name="description" id="description" placeholder="Type your comment here"></textarea>
                </div>
            </div>
			<div class="form-group">
                    <@spring.bind "newRepairForm.repairDate"/>
                    <label class="col-sm-3 control-label">Date of repair</label>
                    <div class="col-sm-9">
                        <input type="datetime-local" name="repairDate" id="repairDate" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <@spring.bind "newRepairForm.repairStatus"/>
                    <label class="col-sm-3 control-label">Repair status</label>
                    <div class="col-sm-9">
                        <select name="repairStatus" id="repairStatus" class="form-control">
                            <option name="repairStatus" value="Pending">Pending</option>
                            <option name="repairStatus" value="InProgress">In progress</option>
                            <option name="repairStatus" value="Done">Done</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                   <@spring.bind "newRepairForm.repairType"/>
                    <label class="col-sm-3 control-label">Repair type</label>
                    <div class="col-sm-9">
                        <select name="repairType" id="repairType" class="form-control">
                            <option name="repairType" value="Small" >Small</option>
                            <option name="repairType" value="Big" >Big</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                  <@spring.bind "newRepairForm.cost"/>
                  <label class="col-sm-3 control-label">Repair Cost</label>
                  <div class="col-sm-9">
                      <input type="text" name="cost" id="cost" placeholder="$$$" class="form-control">
                  </div>
                </div>

            <!-- /.form-group -->
			<div class="form-group">
				<div class="col-sm-9 col-sm-offset-3">
					<button type="submit" class="btn btn-primary btn-block">Save Repair</button>
				</div>
			</div>
        </form> <!-- /form -->
	</div> <!-- ./container -->


</body>