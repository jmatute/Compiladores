type esto
  dim a as integer
  dim b as boolean
  dim c as variant
end type
$
function otra(byval a as boolean) as integer
  otra = 5
end function

function esta(byval cad as string,byref i as integer) as boolean
  return true
end function

function uno(byval dos as string) as integer
  return 7
end function

function dos(byval a as char) as integer
  return 5
end function

Sub main()
  dim a as variant
  dim b as integer
  dim c as boolean
  a= true
  b = 3
  b = 3 +1
  a = not a
  if a then
    write "hello"
  end if
end sub
