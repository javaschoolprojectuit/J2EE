function validateProductForm(event) {
    event.preventDefault(); // this will prevent the submit event.
    if(document.editCategoryForm.name.value=="")
    {
      document.editCategoryForm.name.focus();
      return false;
    }
    else {
    	console.log(document.editCategoryForm.action.value);
        document.editCategoryForm.submit();// fire submit event
    }
}