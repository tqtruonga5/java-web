
<form method='POST' action='SearchServlet'>
    <table>
        <tr>
            <td><label>By Name</label></td>
            <td><input type='text' id='name' name='name'></td>
        </tr>
        <tr>
            <td><label>By Category</label></td>
            <td><select name='category'>
                    <option value='Smartphone'>Smartphone</option>
                    <option value='Laptop'>Laptop</option>
                    <option value='Motorbike'>Motorbike</option>
                    <option value='Mouse'>Mouse</option>
                    <option value='Headphone'>Headphone</option>
                    <option value='Music Player'>Music Player</option>
                    <option value='Supercar'>Supercar</option>
            </select></td>
        </tr>
        <tr>
            <td><label>Price Range </label></td>
            <td><input type='number' id='from' name='price-from'>TO</td>
            <td><input type='number' id='to' name='price-to'></td>
        </tr>
        <tr>
            <td><label>Order By</label></td>
            <td>
                <select name='order-by'>
                    <option value='product_name'>Name</option>
                    <option value='product_price'>Price</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type='submit' value='submit'></td>
        </tr>
    </table>
</form>