<!DOCTYPE html>
<html>
<head>
    <title>GroupDocs.Comparison for Java</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"/>
</head>
<body>
<!-- Minimal HTML form
<form action="upload" method="post" enctype="multipart/form-data">
    <input type="file" name="source"/>
    <input type="file" name="target"/>
    <select name="comparison-type">
        <option value="2">Words</option>
        <option value="3">Cells</option>
        <option value="4">Pdf</option>
        <option value="1">Slides</option>
        <option value="0">Text</option>
    </select>
    <button type="submit">Compare &amp; Download Results</button>
</form>
-->
<form action="upload" method="post" enctype="multipart/form-data">
    <div style="padding: 20px 21px 0px 21px;">
        <font size="5">GroupDocs.Comparison for Java</font>&nbsp; Compare any document
        <hr/>

        <div style="padding: 20px 20px 20px 20px; text-align: left;">
            <div class="alert alert-danger" style="display: none;" id="labelFailed">
            </div>
            <div class="alert alert-success" style="display: none;" id="labelCompleted">
            </div>
            <div class="panel panel-primary" style="width: 100%;">
                <div class="panel-heading">
                    <h4><b>[::] GroupDocs.Comparison for Java</b></h4>
                </div>
                <div class="panel-body">
                    <table width="100%">
                        <tr>
                            <td>
                                <div style="padding: 20px;">
                                    <div class="panel panel-info">
                                        <div class="panel-heading" style="text-transform: uppercase;">
                                            <b>Source file</b>
                                        </div>
                                        <div class="panel-body">
                                            <div class="input-group">
                                                <input type="file" name="source" width="100%" class="input"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div style="padding: 20px;">
                                    <div class="panel panel-info">
                                        <div class="panel-heading" style="text-transform: uppercase;">
                                            <b>Target file</b>
                                        </div>
                                        <div class="panel-body">
                                            <div class="input-group">
                                                <input type="file" name="target" width="100%" class="input"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </table>
                    <div style="text-align: center;">
                        <label>
                            Comparison Type
                            <select name="comparison-type">
                                <option value="2">Words</option>
                                <option value="3">Cells</option>
                                <option value="4">Pdf</option>
                                <option value="1">Slides</option>
                                <option value="0">Text</option>
                            </select>
                        </label>
                        <br/>
                        <input type="submit" value="Compare &amp; Download Results" class="btn btn-success"/>

                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
