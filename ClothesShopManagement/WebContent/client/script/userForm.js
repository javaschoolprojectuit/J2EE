function validateProductForm(event) {
    event.preventDefault(); // this will prevent the submit event.
    if(document.editUserForm.fname.value=="")
    {
      document.editUserForm.fname.focus();
      return false;
    }
    else if(document.editUserForm.lname.value=="")
    {
      document.editUserForm.lname.focus();
      return false;
    }
    else if(document.editUserForm.address.value=="")
    {
      document.editUserForm.address.focus();
      return false;
    }
    else if(document.editUserForm.city.value=="")
    {
      document.editUserForm.city.focus();
      return false;
    }
    else if(document.editUserForm.email.value=="")
    {
      document.editUserForm.email.focus();
      return false;
    }
    else if(document.editUserForm.phone.value=="")
    {
      document.editUserForm.phone.focus();
      return false;
    }
    else if(document.editUserForm.username.value=="")
    {
      document.editUserForm.username.focus();
      return false;
    }
    else if(document.editUserForm.password.value=="")
    {
      document.editUserForm.password.focus();
      return false;
    }
    else if(document.editUserForm.action.value=="")
    {
      document.editUserForm.action.focus();
      return false;
    }
    else {
    	console.log(document.editUserForm.action.value);
        document.editUserForm.submit();// fire submit event
    }
}