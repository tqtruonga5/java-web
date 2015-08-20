<form method="POST" action="LoginServlet">
     <table>
          <tr>
               <td><label>By Name</label></td>
               <td><input type='text' id='name' name='name'></td>
          </tr>
          <tr>
               <td><label>By Category</label></td>
               <td><select name="category">
                         <option value="category1">Category1</option>
                         <option value="category2">Category2</option>
                         <option value="category3">Category3</option>
                         <option value="category4">Category4</option>
               </select></td>
          </tr>
          <tr>
               <td><label>Price Range </label></td>
               <td><input type="number" id='from' name='price-from'></td>
               <td><input type='number' id='to' name='price-to'></td>
          </tr>
          <tr>
               <td>&nbsp;</td>
               <td><input type='submit' value='submit'></td>
          </tr>
     </table>
</form>