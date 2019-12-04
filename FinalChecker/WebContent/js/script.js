function validateMovieForm()
{
  var title=document.forms["editMovieForm"]["title"].value;
  var boxOffice=document.forms["editMovieForm"]["boxOffice"].value;
  var launchDate=document.forms["editMovieForm"]["dateOfLaunch"].value;
  var genre=document.forms["editMovieForm"]["genre"].value;
  if(title=="")
  {
    alert("Title is required");
    return false;
  }
  else if(title.length<2||title.length>100)
  {
    alert("Title should have 2 to 100 characters");
    return false;  
  }
  if(boxOffice=="")
  {
    alert("Gross ($) is required");
    return false;
  }
  else if(isNaN(boxOffice))
  {
    alert("Price has to be a number");
    return false;
  }
  if(launchDate=="")
  {
    alert("Date of Launch is required");
    return false;
  }
  if(genre=="")
  {
    alert("Select one Genre");
    return false;
  }
  
}