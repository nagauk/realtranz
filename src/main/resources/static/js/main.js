

$(document).ready(function(){
    $('.eBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

console.log(href);
            $.get(href, function (country, status) {
                $('.myForm #id').val(country.plotId);
                $('.myForm #name').val(country.plotSize);
                $('.myForm #capital').val(country.facing);

            });

            $('.myForm #exampleModal').modal();
        }



});