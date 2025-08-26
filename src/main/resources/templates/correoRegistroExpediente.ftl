<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="utf-8" />
</head>
<body>
    <table>
        <thead>
            <tr>
                <th style="text-align:center;">
                    <img src="https://movil.pension65.gob.pe/webpension/images/encabezado01.jpg" alt="Pension65" width="402" height="80">
                </th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>
                <br>
                <span style="font-family: Arial; text-align: justify">
                    Estimado usuario(a): ${correo.nombre}
                    <br /><br />
                    La solicitud relacionada a: 
                    <br />
                    <b>${correo.asunto}, ha sido aprobada</b>
                    <br />
                   	<br />
                     Su número de expediente es:
                    <br /><br />
                    <div style="display:inline-block; padding:14px 25px; text-align:center; text-decoration:none; font-size: 16px; opacity:0.9; color:#FFFFFF; background-color:#f44336;" >${correo.numexp}</div>
                	<br /><br />
                	</span>
                </td>
            </tr>
            <tr>
            	<td>
            	<br />
            	<span style="font-family: Arial; text-align: justify">
                La información contenida en este e-mail y sus anexos es confidencial, privilegiada y está dirigida exclusivamente a su destinatario, en consecuencia, solo puede ser utilizada por aquel.
				Si usted no es el destinatario original, no deberá examinar, usar, copiar o distribuir este mensaje o la información que contiene.
				Si lo recibe por error, por favor reenvíelo a la persona que se lo envió y elimínelo. Cualquier retención o uso total o parcial no autorizada de este mensaje está estrictamente prohibida y sancionada por ley.
            	</span>
            	</td>
            </tr>
        </tbody>
    </table>
</body>
</html>
