$("#getAll-btn").click(function () {
    console.log("clicked")
    $.ajax({
        url:"http://localhost:8080/10_BackEnd_Web_exploded/api/v1/customer/getAll",
        method:"GET",
        success:function (response) {
            console.log(response)
        },
        error:function (error) {
            console.log(error)
        }
    })
})

$("#save-btn").click(function () {
    //
})

$("#edit-btn").click(function () {
    //
})
$("#delete-btn").click(function () {
    //
})