function validateProductForm(event) {
    event.preventDefault(); // this will prevent the submit event.
    if(document.editProductForm.name.value=="")
    {
      document.editProductForm.name.focus();
      return false;
    }
    else if(document.editProductForm.price.value=="")
    {
      document.editProductForm.price.focus();
      return false;
    }
    else if(document.editProductForm.category.value=="")
    {
      document.editProductForm.category.focus();
      return false;
    }
    else if(document.editProductForm.supplier.value=="")
    {
      document.editProductForm.supplier.focus();
      return false;
    }
    else if(document.editProductForm.action.value=="")
    {
      document.editProductForm.action.focus();
      return false;
    }
    else {
    	console.log(document.editProductForm.action.value);
        document.editProductForm.submit();// fire submit event
    }
}