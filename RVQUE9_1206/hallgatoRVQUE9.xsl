<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes" />

    <xsl:template match="/">
        <html>
            <head>
                <title>Hallgatók</title>
                <style>
                    table {
                        width: 100%;
                        border-collapse: collapse;
                    }
                    th, td {
                        border: 1px solid black;
                        padding: 8px;
                        text-align: left;
                    }
                    th {
                        background-color: #f2f2f2;
                    }
                </style>
            </head>
            <body>
                <h2>Hallgatók</h2>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Vezetéknév</th>
                        <th>Keresztnév</th>
                        <th>Becenév</th>
                        <th>Kor</th>
                        <th>Ösztöndíj</th>
                    </tr>
                    <xsl:for-each select="//student">
                        <tr>
                            <td><xsl:value-of select="@id" /></td>
                            <td><xsl:value-of select="vezeteknev" /></td>
                            <td><xsl:value-of select="keresztnev" /></td>
                            <td><xsl:value-of select="becenev" /></td>
                            <td><xsl:value-of select="kor" /></td>
                            <td><xsl:value-of select="osztonndij" /></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>